package runday.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import runday.domain.*;

@Component
public class FriendsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Friends>> {

    @Override
    public EntityModel<Friends> process(EntityModel<Friends> model) {
        return model;
    }
}
