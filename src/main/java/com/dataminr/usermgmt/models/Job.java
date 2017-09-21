package com.dataminr.usermgmt.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Job
{

    private int id;

    @NotNull
    private int type;

    @NotNull
    @Size(min = 10, max = 1000)
    private String payload;

    public Job()
    {

    }

    public Job(int type, String payload)
    {
        this.type = type;
        this.payload = payload;
    }

    public Job(int id, int type, String payload)
    {
        this.id = id;
        this.type = type;
        this.payload = payload;
    }

    public int getId()
    {
        return id;
    }

    public Job setId(int id)
    {
        this.id = id;
        return this;
    }

    public int getType()
    {
        return type;
    }

    public Job setType(int type)
    {
        this.type = type;
        return this;
    }

    public String getPayload()
    {
        return payload;
    }

    public Job setPayload(String payload)
    {
        this.payload = payload;
        return this;
    }
}
