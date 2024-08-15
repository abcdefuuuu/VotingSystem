package votingsystem.repository;

import votingsystem.model.VotingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingItemRepository extends JpaRepository<VotingItem, Integer> {
}
