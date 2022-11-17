package com.example.mvvmdemojava.data.local;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalDataSource {

    /**
     * 创建数据库
     */
    void initDatabase();

    /**
     * 关闭数据库
     */
    void closeDatabase();
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取用户密码
     */
    String getPassword();
}