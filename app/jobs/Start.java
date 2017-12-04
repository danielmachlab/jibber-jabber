package jobs;

import models.Chat;
import models.Message;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

/**
 * This is the job run on start up to create the two chat rooms
 * It is only run on start up
 */
public class Start extends Job {

    /**
     * Runs job to create the two chat rooms
     */
    public void doJob() {

        //if (Chat.findAll().size() == 0) {

            Chat jibber = new Chat("jibber");
            jibber.save();

            Chat jabber = new Chat("jabber");
            jabber.save();

        //}
    }
}
