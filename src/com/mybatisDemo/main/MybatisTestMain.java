package com.mybatisDemo.main;

import com.mybatisDemo.mapper.RoleMapper;
import com.mybatisDemo.pojo.Role;
import com.mybatisDemo.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.logging.Logger;

public class MybatisTestMain {
    public static void main(String[] args){

        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();

            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            System.out.println(role.getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null ){
                sqlSession.close();
            }
        }
    }
}
