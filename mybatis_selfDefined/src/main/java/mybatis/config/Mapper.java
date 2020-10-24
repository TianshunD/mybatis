package mybatis.config;

/**
 * 封装执行的SQL和结果类型
 */
public class Mapper {
    private String queryString; //SQL
    private String resultType; //结果TYPE-实体类全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
