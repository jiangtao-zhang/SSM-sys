package com.itheima.ssm.domain;

import java.util.List;

/**
 * +=\|
 *
 * @ClassName Permission
 * @Description 资源权限表
 * @Author jiangtao  zhang
 * @Date 2020/4/24 21:39
 * @Version 1.0
 */
public class Permission {

    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
