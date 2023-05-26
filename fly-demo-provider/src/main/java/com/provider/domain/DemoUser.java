package com.provider.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

@Data
@TableName("demo_user")
public class DemoUser{

    @TableId
    public Long id;

    @TableField(value = "name",jdbcType = JdbcType.VARCHAR)
    public String name;

    @TableField(value = "gender",jdbcType = JdbcType.SMALLINT)
    public Integer gender;
}
