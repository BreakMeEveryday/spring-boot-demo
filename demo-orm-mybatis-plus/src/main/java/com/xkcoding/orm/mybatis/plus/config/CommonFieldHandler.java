package com.xkcoding.orm.mybatis.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * 通用字段填充
 * </p>
 * (1) https://zhuanlan.zhihu.com/p/665347384
 * (2) https://blog.csdn.net/cristianoxm/article/details/119782163
 *
 * @author yangkai.shen
 * @date Created in 2018-11-08 17:40
 */
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // 把mybatis执行的insert方法拦截下来，并对metaObject进行值填充，但是这样的方法似乎拦截的过猛了，所有的insert方法都会拦下来，所以需要在insertFill方法中对metaObject进行判断
        // 但这里情况特殊，createTime和lastUpdateTime是通用字段，即便表里面没有，添加也不妨碍业务逻辑的执行
        // 不用担心其它方法会走到这里，只有添加了@TableField注解的类才会走到这里，能自动填充的一般也是时间这类随系统变化的量
        log.info("metaObject里的originalObject是"+metaObject.getOriginalObject().getClass().toString());
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("lastUpdateTime", new Date(), metaObject);
    }
}
