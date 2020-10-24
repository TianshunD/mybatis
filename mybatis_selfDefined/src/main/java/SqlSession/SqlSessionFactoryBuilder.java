package SqlSession;

import mybatis.config.Configuration;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 自定义创建SqlSessionFactoryBuilder对象的方法
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);

        return new SqlSessionFactoryImpl(cfg);
    }

}
