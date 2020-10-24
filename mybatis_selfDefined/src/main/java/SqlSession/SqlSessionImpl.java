package SqlSession;

import SqlSession.Proxy.MapperProxy;
import mybatis.config.Configuration;
import mybatis.utils.ConnectionUtil;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlSessionImpl implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        this.conn = ConnectionUtil.getConnection(cfg);
    }

    /**创建代理对象*/
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, /**or getInterfaces()*/
                new MapperProxy(cfg.getMappers(), conn));

    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
