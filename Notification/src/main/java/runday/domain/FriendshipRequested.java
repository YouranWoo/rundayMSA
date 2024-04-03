package runday.domain;

import java.util.*;
import lombok.*;
import runday.domain.*;
import runday.infra.AbstractEvent;

@Data
@ToString
public class FriendshipRequested extends AbstractEvent {

    private String id;
    private String friendUserId;
    private String status;
}
