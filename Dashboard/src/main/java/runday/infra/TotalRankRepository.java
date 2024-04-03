package runday.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import runday.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "totalRanks",
    path = "totalRanks"
)
public interface TotalRankRepository
    extends PagingAndSortingRepository<TotalRank, Long> {}
