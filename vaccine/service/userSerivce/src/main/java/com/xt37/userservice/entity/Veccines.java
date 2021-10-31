package com.xt37.userservice.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xt37
 * @since 2021-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Veccines对象", description="")
public class Veccines implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "疫苗id")
    @TableId(value = "vaccinesId", type = IdType.ID_WORKER_STR)
    private String vaccinesId;

    @ApiModelProperty(value = "疫苗图片")
    private String img;

    @ApiModelProperty(value = "疫苗品牌")
    @TableField("vaccinesBrand")
    private String vaccinesBrand;

    @ApiModelProperty(value = "发布的医院id")
    private String hospital;

    @ApiModelProperty(value = "注射用户的状态 1注射第一次 2 注射第二次")
    private Integer type;

    @ApiModelProperty(value = "疫苗价格")
    private BigDecimal price;

    @ApiModelProperty(value = "疫苗的剩余库存")
    private Integer stock;

    @ApiModelProperty(value = "删除")
    private Integer isDelete;

    @ApiModelProperty(value = "插入时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
