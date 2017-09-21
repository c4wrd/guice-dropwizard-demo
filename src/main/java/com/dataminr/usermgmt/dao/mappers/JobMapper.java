package com.dataminr.usermgmt.dao.mappers;

import com.dataminr.usermgmt.models.Job;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobMapper implements ResultSetMapper<Job>
{
    public Job map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException
    {
        return new Job(resultSet.getInt("id"), resultSet.getInt("type"), resultSet.getString("payload"));
    }
}
