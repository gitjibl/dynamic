package com.example.dynamic_test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
 * @since 2021-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SN_HNBI")
@ApiModel(value="SnHnbi对象", description="")
public class SnHnbi extends Model<SnHnbi> {

    private static final long serialVersionUID=1L;

    @TableField("HNCD")
    private String hncd;

    @TableField("HNNM")
    private String hnnm;

    @TableField("BSCD")
    private String bscd;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
