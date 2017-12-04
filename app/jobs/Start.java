package jobs;


import models.Chat;
import models.Message;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Start extends Job {

    public void doJob() {
        System.out.println("Job is running");

        Chat jibber = new Chat("jibber");
        jibber.save();

        Chat jabber = new Chat("jabber");
        jabber.save();
    }
}
