<template>
  <div class="app-container">
    讲师列表
    <!--顶部的条件查询-->

    <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="vaccineQuery.vaccinesBrand" placeholder="疫苗品牌" />
      </el-form-item>

      <el-form-item>
        <el-select
          v-model="vaccineQuery.type"
          clearable
          placeholder="注射次数"
        >
          <el-option :value="1" label="第一次" />
          <el-option :value="2" label="第二次" />
        </el-select>
      </el-form-item>

      <el-form-item label="添加时间">
        <el-date-picker
          v-model="vaccineQuery.begin"
          type="datetime"
          placeholder="选择开始时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="vaccineQuery.end"
          type="datetime"
          placeholder="选择截止时间"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="getList()"
        >查询</el-button
      >
      <el-button type="default" @click="resetData()">清空</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="数据加载中"
      border
      fit
      highlight-current-row
    >
      <el-table-column label="序号" width="150" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="hospital" label="医院名称" width="160" />

      <el-table-column prop="vaccinesBrand" label="疫苗品牌" width="160"/>
   

      <el-table-column prop="price" label="价格" width="160" />

      <el-table-column prop="stock" label="库存" width="160" />

      <el-table-column label="疫苗注射次数" width="160">
        <template slot-scope="type">
          {{ list.type === 1 ? "第二次" : "第一次" }}
        </template>
      </el-table-column>

<el-table-column prop="gmtCreate" label="添加时间" width="180" />
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/vaccine/edit/' + scope.row.vaccinesId">
            <el-button type="primary" size="mini" icon="el-icon-edit"
              >修改</el-button
            >
          </router-link>
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            @click="removeDataById(scope.row.vaccinesId)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getList"

    />
  </div>
</template>

//和后端做交互
<script>
import vaccine from "@/api/vaccine/vaccine";
export default {
  data() {
    // 定义数据  定义数据和初始值
    return {
      list: null, //查询之后接口返回的集合
      page: 1,
      limit: 10,
      vaccineQuery: {},
      hospitalId:"1435595684282707970"
    };
  },

  created() {
    // 当页面加载时获取数据 在页面渲染之前执行
    this.getList();
  },

  methods: {
    //定义具体的方法 调用teacher.js的方法
    //讲师列表
    getList(page = 1) {
      this.page = page;
      vaccine
        .getVaccineList(this.hospitalId,this.vaccineQuery)
        .then(response => {
          //接口返回的数据
          //console.log(response);
          this.list = response.data.records;
          this.total = response.data.total;
          console.log(this.list);
          console.log(this.total);
        })
        .catch(error => {
          console.log(error);
        });
    },
    //搜索中的充值按钮
    resetData() {
      this.teacherQuery = {};
      //清空之后重新查询列表
      this.getList();
    },

    //删除方法
    removeDataById(id) {
      // debugger
      // console.log(memberId)
      this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          return teacher.removeById(id);
        })
        .then(() => {
          this.getList();
          this.$message({
            type: "success",
            message: "删除成功!"
          });
        })
        .catch(response => {
          // 失败
          if (response === "cancel") {
            this.$message({
              type: "info",
              message: "已取消删除"
            });
          } else {
            this.$message({
              type: "error",
              message: "删除失败"
            });
          }
        });
    }
  }
};
</script>
