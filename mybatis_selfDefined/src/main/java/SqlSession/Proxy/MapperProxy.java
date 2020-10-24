package SqlSession.Proxy;

import mybatis.config.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法selectList进行增强
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName(); //方法名
        String className = method.getDeclaringClass().getName(); //方法所在类名称
        String key = className + '.' +methodName; //e.g., domain.User.findAll
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("Illegal Argument!"); //传入参数有误
        }

        //if pass, 调用工具类查询所有
        return new Executor().selectList(mapper,conn);
    }
}
