package com.xkcoding.orm.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色实体类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-09-14 14:04
 */
@Data
@TableName("orm_role")
@Accessors(chain = true) // 当在一个类上添加@Accessors(chain = true)注解时，Lombok 会自动为该类生成链式调用的访问器方法。
@EqualsAndHashCode(callSuper = true)
public class Role extends Model<Role> {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 主键值，ActiveRecord 模式这个必须有，否则 xxById 的方法都将失效！
     * 即使使用 ActiveRecord 不会用到 RoleMapper，RoleMapper 这个接口也必须创建
     * 什么是 mybatis-plus的ActiveRecord 模式？
     * 在 MyBatis-Plus 中，实现 ActiveRecord 模式只需要让实体类继承 Model 类且实现主键指定方法，即可开启 ActiveRecord 之旅。
     */
    @Override
    protected Serializable pkVal() {

        return this.id;
    }
}
