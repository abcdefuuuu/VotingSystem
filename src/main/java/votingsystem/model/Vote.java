package votingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vote {

    @Id
    private Long id;

    @ManyToOne
    private VotingItem votingItem;

    private String voter;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VotingItem getVotingItem() {
        return votingItem;
    }

    public void setVotingItem(VotingItem votingItem) {
        this.votingItem = votingItem;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }
}
