package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.FriendRelationApplication;
import runday.domain.LikeSent;
import runday.domain.LikeUndone;

@Entity
@Table(name = "Likes_table")
@Data
//<<< DDD / Aggregate Root
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userReceivedId;

    private String userSendingId;

    private String runningId;

    private Integer likeScore;

    private Boolean isLike;

    @PostPersist
    public void onPostPersist() {
        LikeSent likeSent = new LikeSent(this);
        likeSent.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        LikeUndone likeUndone = new LikeUndone(this);
        likeUndone.publishAfterCommit();
    }

    public static LikesRepository repository() {
        LikesRepository likesRepository = FriendRelationApplication.applicationContext.getBean(
            LikesRepository.class
        );
        return likesRepository;
    }
}
//>>> DDD / Aggregate Root
