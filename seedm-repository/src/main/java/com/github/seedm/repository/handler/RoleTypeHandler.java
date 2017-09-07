package com.github.seedm.repository.handler;

import com.github.seedm.entities.enumeration.RoleEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 角色枚举类型转换处理器
 * @author Eugene
 */
public class RoleTypeHandler extends BaseTypeHandler<RoleEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, RoleEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getSign());
    }

    @Override
    public RoleEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return RoleEnum.getRoleEnum(rs.getString(columnName));
    }

    @Override
    public RoleEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return RoleEnum.getRoleEnum(rs.getString(columnIndex));
    }

    @Override
    public RoleEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return RoleEnum.getRoleEnum(cs.getString(columnIndex));
    }
}
