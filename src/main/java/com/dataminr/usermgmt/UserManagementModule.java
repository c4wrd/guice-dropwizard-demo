package com.dataminr.usermgmt;

import com.dataminr.usermgmt.config.UserMgmtConfig;
import com.dataminr.usermgmt.dao.JobDAO;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class UserManagementModule extends AbstractModule
{
    protected void configure()
    {
    }

    @Provides
    DBI provideDatasourceFactory(UserMgmtConfig config, Environment environment) {
        final DBIFactory factory = new DBIFactory();
        return factory.build(environment, config.getDataSourceFactory(), "sqlite");
    }

    @Provides
    JobDAO provideJobDao(DBI dbi) {
        return dbi.onDemand(JobDAO.class);
    }

}
