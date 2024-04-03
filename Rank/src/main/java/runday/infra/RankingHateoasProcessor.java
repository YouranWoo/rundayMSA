package runday.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import runday.domain.*;

@Component
public class RankingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ranking>> {

    @Override
    public EntityModel<Ranking> process(EntityModel<Ranking> model) {
        return model;
    }
}
