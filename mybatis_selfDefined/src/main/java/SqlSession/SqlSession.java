package SqlSession;

/**
 * 创建DAO接口的代理对象
 */
public interface SqlSession {
    //泛型先声明后使用
    //根据DAO接口字节码创建代理对象
    <T> T getMapper(Class<T> daoInterfaceClass);

    //release resources
    void close();
}
