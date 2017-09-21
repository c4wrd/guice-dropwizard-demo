package com.dataminr.usermgmt.resources;

import com.dataminr.usermgmt.dao.JobDAO;
import com.dataminr.usermgmt.models.Job;
import com.google.inject.Inject;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/jobs")
public class JobResource
{

    @Inject
    private JobDAO jobDao;

    private int count = 0;

    @GET
    @Path("/count")
    public int getCount() {
        return count;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> getJobs() {
        count++;
        return jobDao.getJobs();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Job getJob(@PathParam("id") int id) {
        return jobDao.getJob(id);
    }


    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Job createJob(@NotNull @Valid final Job job) {
        jobDao.createJob(job);
        int id = jobDao.lastInsertId();
        return job.setId(id);
    }

}
