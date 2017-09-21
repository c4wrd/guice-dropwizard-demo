package com.dataminr.usermgmt.dao;

import com.dataminr.usermgmt.dao.mappers.JobMapper;
import com.dataminr.usermgmt.models.Job;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(JobMapper.class)
public interface JobDAO
{

    @SqlUpdate("CREATE TABLE IF NOT EXISTS jobs (id INTEGER PRIMARY KEY, type INTEGER, payload VARCHAR(1000))")
    void createTableIfNotExists();

    @SqlQuery("SELECT * from jobs;")
    List<Job> getJobs();

    @SqlQuery("SELECT * from jobs WHERE id = :id")
    Job getJob(@Bind("id") final int id);

    @SqlUpdate("INSERT into jobs(type, payload) VALUES(:type, :payload)")
    int createJob(@BindBean Job job);

    @SqlUpdate("UPDATE jobs set payload = coalesce(:payload, payload) WHERE id = :id")
    void editJob(@BindBean Job job);

    @SqlUpdate("DELETE FROM jobs WHERE id = :id")
    int deleteJob(@Bind("id") final int id);

    @SqlQuery("select last_insert_rowid()")
    public int lastInsertId();

}
