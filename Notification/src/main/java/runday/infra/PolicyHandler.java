package runday.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import runday.config.kafka.KafkaProcessor;
import runday.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RunningStarted'"
    )
    public void wheneverRunningStarted_NotifyRunningToFriends(
        @Payload RunningStarted runningStarted
    ) {
        RunningStarted event = runningStarted;
        System.out.println(
            "\n\n##### listener NotifyRunningToFriends : " +
            runningStarted +
            "\n\n"
        );

        // Sample Logic //
        Message.notifyRunningToFriends(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FriendshipRequested'"
    )
    public void wheneverFriendshipRequested_SendRequestMessage(
        @Payload FriendshipRequested friendshipRequested
    ) {
        FriendshipRequested event = friendshipRequested;
        System.out.println(
            "\n\n##### listener SendRequestMessage : " +
            friendshipRequested +
            "\n\n"
        );

        // Sample Logic //
        Message.sendRequestMessage(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FriendshipRequestAccepted'"
    )
    public void wheneverFriendshipRequestAccepted_SendAccpetMessageToRequester(
        @Payload FriendshipRequestAccepted friendshipRequestAccepted
    ) {
        FriendshipRequestAccepted event = friendshipRequestAccepted;
        System.out.println(
            "\n\n##### listener SendAccpetMessageToRequester : " +
            friendshipRequestAccepted +
            "\n\n"
        );

        // Sample Logic //
        Message.sendAccpetMessageToRequester(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
