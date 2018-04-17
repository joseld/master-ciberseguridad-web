package jobs;

import models.Constants;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

import java.io.File;

@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {
        super.doJob();

        File f = new File(Constants.User.USERS_FOLDER);
        f.mkdirs();
    }
}
