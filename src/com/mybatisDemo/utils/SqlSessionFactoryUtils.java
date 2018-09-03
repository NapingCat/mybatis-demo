package com.mybatisDemo.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis单例获取SqlSessionFactory
 */
public class SqlSessionFactoryUtils {
    // 获取当前对象用于加锁
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
    // 空参构造
    private SqlSessionFactoryUtils(){}
    // 创建SqlSessionFactory对象
    private  static SqlSessionFactory sqlSessionFactory = null;

    // 获取SqlSessionFactory方法
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized(LOCK){
            if(null != sqlSessionFactory){
                return sqlSessionFactory;
            }
            InputStream inputStream = null;
            String resources = "mybatis-config.xml";
            try{
                inputStream = Resources.getResourceAsStream(resources);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

// 获取SQL session
    public static SqlSession openSqlSession(){
        if(null == sqlSessionFactory){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

