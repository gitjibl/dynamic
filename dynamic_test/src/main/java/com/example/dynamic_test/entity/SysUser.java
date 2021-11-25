package com.example.dynamic_test.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @author jibl
 * @since 2021-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID=1L;

    @TableId("user_id")
    private String userId;

    @ApiModelProperty(value = "反反复复")
    @TableField("user_name")
    private String userName;

    @TableField("login_name")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("sex")
    private String sex;

    @TableField("telephone")
    private String telephone;

    @TableField("status")
    private String status;

    @TableField("remark")
    private String remark;

    @TableField("operator")
    private String operator;

    @TableField("operate_time")
    private Date operateTime;

    @TableField("operate_ip")
    private String operateIp;

    @TableField("user_extend")
    private String userExtend;

    @TableField("user_extend_one")
    private String userExtendOne;

    @TableField("user_extend_two")
    private String userExtendTwo;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
