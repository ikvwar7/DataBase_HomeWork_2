package ru.liga.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.entity.DepartmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sanasov on 26.04.2017.
 */
public class DepartmentMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DepartmentEntity(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("address"),
                rs.getInt("foundation_year"),
                null,
                null
        );
    }
}