package votingsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import votingsystem.model.VoteRequest;
import votingsystem.model.VotingItem;
import votingsystem.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/items")
    public List<VotingItem> getAllVotingItems() {
        return votingService.getAllVotingItems();
    }

    @PostMapping("/items")
    public VotingItem addVotingItem(@RequestBody VotingItem item) {
        return votingService.addVotingItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteVotingItem(@PathVariable Integer id) {
        votingService.deleteVotingItem(id);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody VoteRequest voteRequest) {
        votingService.vote(voteRequest.getVoter(), voteRequest.getVotingItemIds());
    }

    // 獲取所有投票項目及其票數
    @GetMapping("/items-with-votes")
    public ResponseEntity<List<Map<String, Object>>> getAllVotingItemsWithVotes() {
        List<Map<String, Object>> votingItemsWithVotes = votingService.getAllVotingItemsWithVoteCounts();
        return new ResponseEntity<>(votingItemsWithVotes, HttpStatus.OK);
    }
}
