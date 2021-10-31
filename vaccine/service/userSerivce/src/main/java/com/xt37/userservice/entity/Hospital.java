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
@ApiModel(value="Hospital对象", description="")
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "医院的id")
    @TableId(type = IdType.ID_WORKER_STR)
    private String userid;

    @ApiModelProperty(value = "医院的密码")
    private String password;

    @ApiModelProperty(value = "医院的名字")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "医院的头像")
    private String avatar;

    @ApiModelProperty(value = "删除")
    private Integer isDelete;

    @ApiModelProperty(value = "医院电话")
    private String phone;

    @ApiModelProperty(value = "医院地址")
    private String address;

    @ApiModelProperty(value = "插入时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
