package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.LoggingApplication;
import runday.domain.LikesUpdated;
import runday.domain.LogCompleted;
import runday.domain.LogCreated;
import runday.domain.LogDeleted;
import runday.domain.LogEditted;
import runday.domain.LogRemoved;

@Entity
@Table(name = "Log_table")
@Data
//<<< DDD / Aggregate Root
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long runningId;

    private String userId;

    private Date startTime;

    private Float startLatitude;

    private Float startLongitude;

    private Date endTime;

    private Float endLatitude;

    private Float endLongitude;

    private Long runningTime;

    private String userDiary;

    private Integer likesCount;

    private String runningPhoto;

    @PostPersist
    public void onPostPersist() {
        LogCreated logCreated = new LogCreated(this);
        // logCreated.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        LogEditted logEditted = new LogEditted(this);
        logEditted.publishAfterCommit();

        LogCompleted logCompleted = new LogCompleted(this);
        logCompleted.publishAfterCommit();

        LikesUpdated likesUpdated = new LikesUpdated(this);
        likesUpdated.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove() {
        LogRemoved logRemoved = new LogRemoved(this);
        logRemoved.publishAfterCommit();

        LogDeleted logDeleted = new LogDeleted(this);
        logDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static LogRepository repository() {
        LogRepository logRepository = LoggingApplication.applicationContext.getBean(
            LogRepository.class
        );
        return logRepository;
    }

    //<<< Clean Arch / Port Method
    public static void createLog(RunningStarted runningStarted) {
        
        Log log = new Log();
        log.setRunningId(runningStarted.getId());
        log.setUserId(runningStarted.getUserId());
        log.setStartTime(runningStarted.getStartTime());
        log.setStartLatitude(runningStarted.getStartLatitude());
        log.setStartLongitude(runningStarted.getStartLongitude());

        repository().save(log);

        LogCreated logCreated = new LogCreated(log);
        // logCreated.publishAfterCommit();

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void completeLog(RunningEnded runningEnded) {
        //implement business logic here:

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        LogCompleted logCompleted = new LogCompleted(log);
        logCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(runningEnded.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);

            LogCompleted logCompleted = new LogCompleted(log);
            logCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void removeLog(RunningForcedStop runningForcedStop) {
        //implement business logic here:

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        LogRemoved logRemoved = new LogRemoved(log);
        logRemoved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(runningForcedStop.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);

            LogRemoved logRemoved = new LogRemoved(log);
            logRemoved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikes(LikeUndone likeUndone) {
        //implement business logic here:

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        LikesUpdated likesUpdated = new LikesUpdated(log);
        likesUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(likeUndone.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);

            LikesUpdated likesUpdated = new LikesUpdated(log);
            likesUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikes(LikeSent likeSent) {
        //implement business logic here:

        /** Example 1:  new item 
        Log log = new Log();
        repository().save(log);

        LikesUpdated likesUpdated = new LikesUpdated(log);
        likesUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(likeSent.get???()).ifPresent(log->{
            
            log // do something
            repository().save(log);

            LikesUpdated likesUpdated = new LikesUpdated(log);
            likesUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
