package com.xkcoding.rbac.security.model;

import com.xkcoding.rbac.security.model.unionkey.RolePermissionKey;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 角色-权限
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-10 13:46
 */
@Data
@Entity
@Table(name = "sec_role_permission")
public class RolePermission {
    /**
     * 主键
     */
    @EmbeddedId // 表示该属性是一个复合主键，并且其类型是之前定义过的 @Embeddable 类型。
    private RolePermissionKey id;
}
