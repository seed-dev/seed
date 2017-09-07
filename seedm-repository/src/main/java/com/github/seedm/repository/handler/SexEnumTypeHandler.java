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

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getSign());
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return SexEnum.getSexEnum(rs.getString(columnName));
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexEnum.getSexEnum(rs.getString(columnIndex));
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexEnum.getSexEnum(cs.getString(columnIndex));
    }
}
