package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.Role;

import java.util.List;

public interface RoleMapper {

//    插入一个role对象
    public int insertRole(Role role);
//    删除一个role对象
    public int deleteRole(Long id);
//    修改一个role对象
    public int updateRole(Role role);
//    获取一个role对象
    public Role getRole(Long id);
//    通过角色名获取一个角色对象列表
    public List<Role> findRoles(String roleName);

}
