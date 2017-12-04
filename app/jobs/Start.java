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
        jibber.messages.add(new Message("You are now chatting on jibber"));
        jibber.save();

        Chat jabber = new Chat("jabber");
        jabber.messages.add(new Message("You are now chatting on jabber"));
        jabber.save();
    }
}
