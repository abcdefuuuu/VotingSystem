package votingsystem.service;

import votingsystem.model.Vote;
import votingsystem.model.VotingItem;
import votingsystem.repository.VoteRepository;
import votingsystem.repository.VotingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        for (Integer id : votingItemIds) {
            VotingItem item = votingItemRepository.findById(id).orElseThrow();
            Vote vote = new Vote();
            vote.setVoter(voter); // 確保 Vote 類中有 setVoter 方法
            vote.setVotingItem(item); // 確保 Vote 類中有 setVotingItem 方法
            voteRepository.save(vote);
        }
    }
}
