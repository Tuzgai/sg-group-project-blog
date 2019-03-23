package com.sg.blog.Blog.dao;

import com.sg.blog.Blog.entity.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TagDaoDB implements TagDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Tag getTagByName(String name) {
        try {
            final String GET_TAG_BY_NAME = "SELECT * FROM Tags WHERE name = ?";
            return jdbc.queryForObject(GET_TAG_BY_NAME, new TagMapper(), name);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Tag> getAllTags() {
        final String GET_ALL_TAGS = "SELECT * FROM Tag";
        return jdbc.query(GET_ALL_TAGS, new TagMapper());
    }

   @Override
    @Transactional
    public Tag addTag(Tag tag) {
        final String INSERT_TAG = "INSERT INTO Tag(name) " + "VALUES(?)";
        jdbc.update(INSERT_TAG,
                tag.getName());

        String newName = jdbc.queryForObject("SELECT LAST_INSERT_NAME()", String.class);
        tag.setName(newName);
        return tag;
    }

    @Override
    public void getTagByPost(String post) {       
            final String GET_TAG_BY_POST = "SELECT * FROM Tag";
            
       // Add 
    }

    public static final class TagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int index) throws SQLException {
            Tag tag = new Tag();
            tag.setName(rs.getString("name"));

            return tag;
        }
    }
}
