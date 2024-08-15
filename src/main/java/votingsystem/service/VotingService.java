package votingsystem.service;

import votingsystem.model.Vote;
import votingsystem.model.VotingItem;
import votingsystem.repository.VoteRepository;
import votingsystem.repository.VotingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VotingService {

    @Autowired
    private VotingItemRepository votingItemRepository;

    @Autowired
    private VoteRepository voteRepository;

    public List<VotingItem> getAllVotingItems() {
        return votingItemRepository.findAll();
    }

    @Transactional
    public VotingItem addVotingItem(VotingItem item) {
        return votingItemRepository.save(item);
    }

    @Transactional
    public void deleteVotingItem(Integer id) {
        votingItemRepository.deleteById(id);
    }

    @Transactional
    public void vote(String voter, List<Integer> votingItemIds) {
        for (Integer votingItemId : votingItemIds) {
            VotingItem votingItem = votingItemRepository.findById(votingItemId)
                    .orElseThrow(() -> new RuntimeException("VotingItem not found"));

            Vote vote = new Vote();
            vote.setVoter(voter);
            vote.setVotingItem(votingItem);

            voteRepository.save(vote);
        }
    }

    public List<Map<String, Object>> getAllVotingItemsWithVoteCounts() {
        List<VotingItem> votingItems = votingItemRepository.findAll();
        return votingItems.stream().map(item -> {
            Map<String, Object> itemWithCount = new HashMap<>();
            itemWithCount.put("id", item.getId());
            itemWithCount.put("name", item.getName());
            long voteCount = voteRepository.countByVotingItemId(item.getId());
            itemWithCount.put("voteCount", voteCount);
            return itemWithCount;
        }).collect(Collectors.toList());
    }
}
