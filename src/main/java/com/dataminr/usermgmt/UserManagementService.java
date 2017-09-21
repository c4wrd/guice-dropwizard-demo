package com.dataminr.usermgmt;

import com.dataminr.usermgmt.config.UserMgmtConfig;
import com.dataminr.usermgmt.dao.JobDAO;
import com.dataminr.usermgmt.resources.JobResource;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class UserManagementService extends Application<UserMgmtConfig>
{

    private GuiceBundle<UserMgmtConfig> guiceBundle;

    @Override
    public void initialize(Bootstrap<UserMgmtConfig> bootstrap)
    {
        guiceBundle = GuiceBundle.<UserMgmtConfig>newBuilder()
                .addModule(new UserManagementModule())
                .setConfigClass(UserMgmtConfig.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    public void run(UserMgmtConfig config, Environment environment) throws Exception
    {
        environment.jersey().register(JobResource.class);
    }

    public static void main(String[] args) throws Exception
    {
        new UserManagementService().run(args);
    }
}
