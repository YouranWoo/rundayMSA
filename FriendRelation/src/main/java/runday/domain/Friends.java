package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.FriendRelationApplication;
import runday.domain.FriendshipRequestAccepted;
import runday.domain.FriendshipRequestAdded;
import runday.domain.FriendshipRequestRejected;
import runday.domain.FriendshipRequested;

@Entity
@Table(name = "Friends_table")
@Data
//<<< DDD / Aggregate Root
public class Friends {

    private String friendUserId;

    private String status;

    @Id
    private String id;

    @PostPersist
    public void onPostPersist() {
        FriendshipRequested friendshipRequested = new FriendshipRequested(this);
        friendshipRequested.publishAfterCommit();

        FriendshipRequestAdded friendshipRequestAdded = new FriendshipRequestAdded(
            this
        );
        friendshipRequestAdded.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        FriendshipRequestAccepted friendshipRequestAccepted = new FriendshipRequestAccepted(
            this
        );
        friendshipRequestAccepted.publishAfterCommit();

        FriendshipRequestRejected friendshipRequestRejected = new FriendshipRequestRejected(
            this
        );
        friendshipRequestRejected.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static FriendsRepository repository() {
        FriendsRepository friendsRepository = FriendRelationApplication.applicationContext.getBean(
            FriendsRepository.class
        );
        return friendsRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addFriendshipRequest(
        FriendshipRequested friendshipRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Friends friends = new Friends();
        repository().save(friends);

        FriendshipRequestAdded friendshipRequestAdded = new FriendshipRequestAdded(friends);
        friendshipRequestAdded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(friendshipRequested.get???()).ifPresent(friends->{
            
            friends // do something
            repository().save(friends);

            FriendshipRequestAdded friendshipRequestAdded = new FriendshipRequestAdded(friends);
            friendshipRequestAdded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
