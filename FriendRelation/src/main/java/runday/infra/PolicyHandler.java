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
    FriendsRepository friendsRepository;

    @Autowired
    LikesRepository likesRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FriendshipRequested'"
    )
    public void wheneverFriendshipRequested_AddFriendshipRequest(
        @Payload FriendshipRequested friendshipRequested
    ) {
        FriendshipRequested event = friendshipRequested;
        System.out.println(
            "\n\n##### listener AddFriendshipRequest : " +
            friendshipRequested +
            "\n\n"
        );

        // Sample Logic //
        Friends.addFriendshipRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
