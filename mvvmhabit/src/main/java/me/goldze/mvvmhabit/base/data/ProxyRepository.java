package me.goldze.mvvmhabit.base.data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类，根据接口等信息动态地创建代理对象，其中 ProxyRepository 是 InvocationHandler 的实现类，用于绑定方法
 */
public class ProxyRepository extends BaseModel implements InvocationHandler{

    //单例模式
    private volatile static ProxyRepository INSTANCE = null;

    // tar用于接收目标类的参数
    private Object target;

    // 绑定目标类，根据目标类的类加载器和接口创建代理对象，并返回（使用泛型避免强转问题）
    public <T> T bind(T target) {
        this.target = target;
        // 注意：此处代码返回代理类
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = method.invoke(target, objects);
        return result;
    }

    //单例模式
    public static ProxyRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (ProxyRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProxyRepository();
                }
            }
        }
        return INSTANCE;
    }


}
