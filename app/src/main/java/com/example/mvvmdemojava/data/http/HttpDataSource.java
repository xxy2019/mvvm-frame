package com.example.mvvmdemojava.data.http;

import com.example.mvvmdemojava.entity.DemoEntity;
import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.entity.BaseResponseEntity;

public interface HttpDataSource {

    Observable<BaseResponseEntity<DemoEntity>> demoGet();

    Observable<BaseResponseEntity<DemoEntity>> demoPost(String catalog);

}
