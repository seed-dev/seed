package com.github.seedm.repository.handler;

import com.github.seedm.entities.enumeration.StatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 状态枚举类型转换处理器
 * @author Eugene
 */
public class StatusEnumTypeHandler extends BaseTypeHandler<StatusEnum> {

    private Class<StatusEnum> type;

    private  StatusEnum [] enums;

    public StatusEnumTypeHandler() {
    }

    public StatusEnumTypeHandler(Class<StatusEnum> type) {
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
    public void setNonNullParameter(PreparedStatement ps, int i, StatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getStatus());
    }

    @Override
    public StatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getInt(columnName));
    }

    @Override
    public StatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getInt(columnIndex));
    }

    @Override
    public StatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getInt(columnIndex));
    }

    /**
     * 转换为枚举
     * @param status 数据库的值
     * @return 枚举
     */
    private StatusEnum convert(int status){
        StatusEnum [] statusEnums = type.getEnumConstants();
        for(StatusEnum statusEnum: statusEnums){
            if(statusEnum.getStatus() == status){
                return  statusEnum;
            }
        }
        return null;
    }
}
