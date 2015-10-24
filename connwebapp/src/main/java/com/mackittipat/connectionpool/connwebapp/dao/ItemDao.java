package com.mackittipat.connectionpool.connwebapp.dao;

import com.mackittipat.connectionpool.connwebapp.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ItemModel save(ItemModel itemModel) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new ItemPrepareStatementCreator(itemModel), keyHolder);
        itemModel.setId(keyHolder.getKey().intValue());
        return itemModel;
    }

    private class ItemPrepareStatementCreator implements PreparedStatementCreator {

        private ItemModel itemModel;

        public ItemPrepareStatementCreator(ItemModel itemModel) {

            this.itemModel = itemModel;
        }

        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO item(title) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            int parameterIndex = 1;
            preparedStatement.setString(parameterIndex++, itemModel.getTitle());
            return preparedStatement;
        }
    }
}
