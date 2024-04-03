package runday.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import runday.domain.*;

@Component
public class LikesHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Likes>> {

    @Override
    public EntityModel<Likes> process(EntityModel<Likes> model) {
        return model;
    }
}
