package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.RankApplication;
import runday.domain.UserRanked;

@Entity
@Table(name = "Ranking_table")
@Data
//<<< DDD / Aggregate Root
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String totalRunningTime;

    private String userRank;

    @PostPersist
    public void onPostPersist() {
        UserRanked userRanked = new UserRanked(this);
        userRanked.publishAfterCommit();
    }

    public static RankingRepository repository() {
        RankingRepository rankingRepository = RankApplication.applicationContext.getBean(
            RankingRepository.class
        );
        return rankingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void rankUser(RunningEnded runningEnded) {
        //implement business logic here:

        /** Example 1:  new item 
        Ranking ranking = new Ranking();
        repository().save(ranking);

        UserRanked userRanked = new UserRanked(ranking);
        userRanked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(runningEnded.get???()).ifPresent(ranking->{
            
            ranking // do something
            repository().save(ranking);

            UserRanked userRanked = new UserRanked(ranking);
            userRanked.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
