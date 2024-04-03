package runday.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import runday.NotificationApplication;
import runday.domain.AccpetMessageSent;
import runday.domain.RequestMessageSent;
import runday.domain.RunuinngNotifiedToFriends;

@Entity
@Table(name = "Message_table")
@Data
//<<< DDD / Aggregate Root
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String message;

    @PostPersist
    public void onPostPersist() {
        RunuinngNotifiedToFriends runuinngNotifiedToFriends = new RunuinngNotifiedToFriends(
            this
        );
        runuinngNotifiedToFriends.publishAfterCommit();

        RequestMessageSent requestMessageSent = new RequestMessageSent(this);
        requestMessageSent.publishAfterCommit();

        AccpetMessageSent accpetMessageSent = new AccpetMessageSent(this);
        accpetMessageSent.publishAfterCommit();
    }

    public static MessageRepository repository() {
        MessageRepository messageRepository = NotificationApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyRunningToFriends(RunningStarted runningStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        RunuinngNotifiedToFriends runuinngNotifiedToFriends = new RunuinngNotifiedToFriends(message);
        runuinngNotifiedToFriends.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(runningStarted.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            RunuinngNotifiedToFriends runuinngNotifiedToFriends = new RunuinngNotifiedToFriends(message);
            runuinngNotifiedToFriends.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void sendRequestMessage(
        FriendshipRequested friendshipRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        RequestMessageSent requestMessageSent = new RequestMessageSent(message);
        requestMessageSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(friendshipRequested.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            RequestMessageSent requestMessageSent = new RequestMessageSent(message);
            requestMessageSent.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void sendAccpetMessageToRequester(
        FriendshipRequestAccepted friendshipRequestAccepted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        AccpetMessageSent accpetMessageSent = new AccpetMessageSent(message);
        accpetMessageSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(friendshipRequestAccepted.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);

            AccpetMessageSent accpetMessageSent = new AccpetMessageSent(message);
            accpetMessageSent.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
