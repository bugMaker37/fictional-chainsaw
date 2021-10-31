<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="疫苗品牌">
        <el-input style="width: 500px;" v-model="vaccine.vaccinesBrand" />
      </el-form-item>
      <el-form-item label="发布医院">
        <el-input style="width: 500px;" v-model="vaccine.hospital" />
      </el-form-item>
      <el-form-item label="注射次数" >
        <el-select v-model="vaccine.type" style="width: 500px;" clearable placeholder="请选择">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
          -->
          <el-option :value="1" label="第一次" />
          <el-option :value="2" label="第二次" />
        </el-select>
      </el-form-item>
      <el-form-item label="库存" >
        <el-input v-model="vaccine.stock" style="width: 500px;" />
      </el-form-item>
      <el-form-item label="价格" >
        <el-input v-model="vaccine.price" style="width: 500px;" :rows="10" />
      </el-form-item>

      <!-- 讲师头像 -->
      <el-form-item label="疫苗图片">
        <!-- 头衔缩略图 -->
        <pan-thumb :image="vaccine.img" />
        <!-- 文件上传按钮 -->
        <el-button
          type="primary"
          icon="el-icon-upload"
          @click="imagecropperShow = true"
          >更换头像
        </el-button>

        <!--
        v-show：是否显示上传组件
        :key：类似于id，如果一个页面多个图片上传控件，可以做区分
        :url：后台上传的url地址
        @close：关闭上传组件
        @crop-upload-success：上传成功后的回调 -->

        <image-cropper
          v-show="imagecropperShow"
          :width="300"
          :height="300"
          :key="imagecropperKey"
          :url="'/eduoss/fileoss'"
          field="file"
          @close="close"
          @crop-upload-success="cropSuccess"
        />
      </el-form-item>

      <el-form-item>
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate"
          >保存</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import vaccine from "@/api/vaccine/vaccine";
import ImageCropper from "@/components/ImageCropper";
import PanThumb from "@/components/PanThumb";
export default {
  components: { ImageCropper, PanThumb },
  data() {
    return {
      vaccine: {
        hospital: "",
        vaccinesBrand: 0,
        type: 1,
        price: "",
        stock: "",
        img: ""
      },
      imagecropperKey: 0,
      imagecropperShow: false,
      saveBtnDisabled: false, // 保存按钮是否禁用,
      BASE_API: process.env.BASE_API
    };
  },

  created() {
    this.init();
  },
  //监听 固定写法 监听路由变化的方式  每次跳转都会执行 不管是不是同一个页面
  watch: {
    $route(to, from) {
      console.log("watch $route");
      this.init();
    }
  },

  methods: {
    //关闭上传弹框的方法
    close() {
      this.imagecropperShow = false;
      // 上传失败后，重新打开上传组件时初始化组件，否则显示上一次的上传结果
      this.imagecropperKey = this.imagecropperKey + 1;
    },

    //上传成功的方法
    cropSuccess(data) {
      console.log(data);
      this.imagecropperShow = false;
      this.vaccine.img = data.url;
      // 上传成功后，重新打开上传组件时初始化组件，否则显示上一次的上传结果
      this.imagecropperKey = this.imagecropperKey + 1;
    },

    //每次访问页面的时候根据访问的方式进行决定是否进行页面的重置
    init() {
      if (this.$route.params && this.$route.params.id) {
        const id = this.$route.params.id;
        this.fetchDataById(id);
      } else {
        // 使用对象拓展运算符，拷贝对象，而不是引用，
        // 否则新增一条记录后，defaultForm就变成了之前新增的teacher的值
        this.vaccine = {};
      }
    },
    //添加或更新用户
    saveOrUpdate() {
      this.saveBtnDisabled = true;
      if (!this.vaccine.id) {
        this.saveData();
      } else {
        this.updateTeacher();
      }
    },

    // 保存新增讲师的功能
    saveData() {
      vaccine
        .save(this.vaccine)
        .then(response => {
          return this.$message({
            type: "success",
            message: "保存成功!"
          });
        })
        .then(resposne => {
          this.$router.push({ path: "/vaccine/vaccineList" });
        })
        .catch(response => {
          // console.log(response)
          this.$message({
            type: "error",
            message: "保存失败"
          });
        });
    },


    // 根据id查询记录
    fetchDataById(id) {
      vaccine
        .getById(id)
        .then(response => {
          this.vaccine = response.data.vaccine;
        })
        .catch(response => {
          this.$message({
            type: "error",
            message: "获取数据失败"
          });
        });
    },


    //修改讲师的方法
    updateTeacher() {
      this.saveBtnDisabled = true;
      vaccine
        .updateTeacher(this.vaccine)
        .then(response => {
          return this.$message({
            type: "success",
            message: "修改成功!"
          });
        })
        .then(resposne => {
          this.$router.push({ path: "/vaccine/vaccineList" });
        })
        .catch(response => {
          // console.log(response)
          this.$message({
            type: "error",
            message: "保存失败"
          });
        });
    }
  }
};
</script>
