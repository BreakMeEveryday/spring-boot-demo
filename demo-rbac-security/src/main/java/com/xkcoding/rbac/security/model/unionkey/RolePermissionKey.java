package com.xkcoding.rbac.security.model.unionkey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <p>
 * 角色-权限联合主键
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-10 13:47
 */
@Data
@Embeddable // 表示该类是一个可嵌入的实体（Embeddable Entity），即它可以作为另一个实体的一部分，作为一个复合主键或者普通字段存在。
public class RolePermissionKey implements Serializable {
    private static final long serialVersionUID = 6850974328279713855L;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Long permissionId;
}
