package com.github.seedm.repository.handler;

import com.github.seedm.entities.enumeration.RoleEnum;
import com.github.seedm.entities.enumeration.RoleEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 角色枚举类型转换处理器
 * @author Eugene
 */
public class RoleTypeHandler extends BaseTypeHandler<RoleEnum> {

    private Class<RoleEnum> type;

    private  RoleEnum [] enums;

    public RoleTypeHandler() {
    }

    public RoleTypeHandler(Class<RoleEnum> type) {
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
    public void setNonNullParameter(PreparedStatement ps, int i, RoleEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getSign());
    }

    @Override
    public RoleEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getString(columnName));
    }

    @Override
    public RoleEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getString(columnIndex));
    }

    @Override
    public RoleEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getString(columnIndex));
    }

    /**
     * 转换为枚举
     * @param sign 数据库的值
     * @return 枚举
     */
    private RoleEnum convert(String sign){
        RoleEnum [] RoleEnums = type.getEnumConstants();
        for(RoleEnum RoleEnum : RoleEnums){
            if(RoleEnum.getSign().equals(sign)){
                return  RoleEnum;
            }
        }
        return null;
    }
}
