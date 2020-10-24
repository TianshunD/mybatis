package SqlSession;

import mybatis.config.Configuration;

/**
 SqlSessionFactory接口的实现类
 */

public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
