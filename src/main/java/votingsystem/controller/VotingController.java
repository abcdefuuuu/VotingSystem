package votingsystem.controller;

import votingsystem.model.VotingItem;
import votingsystem.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void vote(@RequestParam String voter, @RequestBody List<Integer> votingItemIds) {
        votingService.vote(voter, votingItemIds);
    }
}
