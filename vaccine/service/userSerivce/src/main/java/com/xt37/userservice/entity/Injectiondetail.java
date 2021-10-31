package com.xt37.userservice.entity;

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
@ApiModel(value="Injectiondetail对象", description="")
public class Injectiondetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "注射信息的id")
    @TableId(value = "injectionId", type = IdType.ID_WORKER_STR)
    private String injectionId;

    @ApiModelProperty(value = "被注射的用户id")
    @TableField("userId")
    private String userId;

    @ApiModelProperty(value = "注射医院的id")
    @TableField("hospitalId")
    private String hospitalId;

    @ApiModelProperty(value = "注射疫苗的信息id")
    @TableField("vaccineId")
    private String vaccineId;

    @ApiModelProperty(value = "描述")
    private String decriptioin;

    @ApiModelProperty(value = "注射时间")
    @TableField("injectionTime")
    private Date injectionTime;

    @ApiModelProperty(value = "用户注射的状态 1注射第一次 2注射第二次")
    private Integer type;

    @ApiModelProperty(value = "删除")
    private Integer isDelete;

    @ApiModelProperty(value = "插入时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
