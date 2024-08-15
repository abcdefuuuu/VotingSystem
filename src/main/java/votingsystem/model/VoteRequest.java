package votingsystem.model;

import java.util.List;

public class VoteRequest {
    private String voter;
    private List<Integer> votingItemIds;

    // Getters and setters
    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public List<Integer> getVotingItemIds() {
        return votingItemIds;
    }

    public void setVotingItemIds(List<Integer> votingItemIds) {
        this.votingItemIds = votingItemIds;
    }
}
