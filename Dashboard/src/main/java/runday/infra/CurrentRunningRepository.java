package runday.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runday.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "currentRunnings",
    path = "currentRunnings"
)
public interface CurrentRunningRepository
    extends PagingAndSortingRepository<CurrentRunning, Long> {}
