package com.example.mvvmdemojava.app;

import com.example.mvvmdemojava.data.DemoRepository;
import com.example.mvvmdemojava.data.source.HttpDataSource;
import com.example.mvvmdemojava.data.source.LocalDataSource;
import com.example.mvvmdemojava.data.source.http.HttpDataSourceImpl;
import com.example.mvvmdemojava.data.source.local.LocalDataSourceImpl;

/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static DemoRepository provideDemoRepository() {
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance();
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return DemoRepository.getInstance(httpDataSource, localDataSource);
    }
}
