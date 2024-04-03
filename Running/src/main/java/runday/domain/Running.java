package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.RunningApplication;
import runday.domain.RunningEnded;
import runday.domain.RunningForcedStop;
import runday.domain.RunningPaused;
import runday.domain.RunningRestarted;
import runday.domain.RunningStarted;

@Entity
// @EntityListeners(Running.class)
@Table(name = "Running_table")
@Data
//<<< DDD / Aggregate Root
public class Running {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Date startTime;

    private Float startLatitude;

    private Float startLongitude;

    private Date pauseStartTime;

    private Date pauseEndTime;

    private Date totalPauseTime;

    private Date endTime;

    private Float endLatitude;

    private Float endLongitude;

    private Date runningTime;

    @PostPersist
    public void onPostPersist() {
        RunningStarted runningStarted = new RunningStarted(this);
        runningStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {

        // EntityManager entityManager = EntityManagerFactory.createEntityManager();
        // Running oldRunning = entityManager.find(Running.class, running.getId());
        // TODO: Persistency unit 추가
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Running oldRunning = entityManager.find(Running.class, this.getId());

        if (!oldRunning.getPauseStartTime().equals(this.getPauseStartTime())) {
            RunningPaused runningPaused = new RunningPaused(this);
            runningPaused.publishAfterCommit();
        } else if (!oldRunning.getPauseEndTime().equals(this.getPauseEndTime())){
            RunningRestarted runningRestarted = new RunningRestarted(this);
            runningRestarted.publishAfterCommit();
        } else if (!oldRunning.getEndTime().equals(this.getEndTime())){
            RunningEnded runningEnded = new RunningEnded(this);
            runningEnded.publishAfterCommit();
        } else {
            RunningForcedStop runningForcedStop = new RunningForcedStop(this);
            runningForcedStop.publishAfterCommit();
        }
        
        entityManager.close();
    }

    public static RunningRepository repository() {
        RunningRepository runningRepository = RunningApplication.applicationContext.getBean(
            RunningRepository.class
        );
        return runningRepository;
    }

    //<<< Clean Arch / Port Method
    public static void forceStopRunningIfMoreThan10Min(
        RunningPaused runningPaused
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Running running = new Running();
        repository().save(running);

        RunningForcedStop runningForcedStop = new RunningForcedStop(running);
        runningForcedStop.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(runningPaused.get???()).ifPresent(running->{
            
            running // do something
            repository().save(running);

            RunningForcedStop runningForcedStop = new RunningForcedStop(running);
            runningForcedStop.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
