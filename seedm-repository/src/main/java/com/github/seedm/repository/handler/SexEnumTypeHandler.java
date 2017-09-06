package com.github.seedm.repository.handler;

import com.github.seedm.entities.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 性别枚举类型转换处理器
 * @author Eugene
 */
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {

    private Class<SexEnum> type;

    private  SexEnum [] enums;

    public SexEnumTypeHandler() {
    }

    public SexEnumTypeHandler(Class<SexEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }

        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getSign());
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getString(columnName));
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getString(columnIndex));
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getString(columnIndex));
    }

    /**
     * 转换为枚举
     * @param sex 数据库的值
     * @return 枚举
     */
    private SexEnum convert(String sex){
        SexEnum [] sexEnums = type.getEnumConstants();
        for(SexEnum sexEnum: sexEnums){
            if(sexEnum.getSign().equals(sex)){
                return  sexEnum;
            }
        }
        return null;
    }
}
