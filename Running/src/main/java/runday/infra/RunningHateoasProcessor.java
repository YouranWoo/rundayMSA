package runday.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import runday.domain.*;

@Component
public class RunningHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Running>> {

    @Override
    public EntityModel<Running> process(EntityModel<Running> model) {
        return model;
    }
}
