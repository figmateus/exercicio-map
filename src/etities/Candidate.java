package etities;

import java.util.Objects;

public class Candidate implements Comparable<Candidate>{

    String name;
    Double votes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate candidate)) return false;
        return Objects.equals(getName(), candidate.getName()) && Objects.equals(getVotes(), candidate.getVotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVotes());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVotes() {
        return votes;
    }

    public void setVotes(Double votes) {
        this.votes = votes;
    }

    public Candidate(String name, Double votes) {
        this.name = name;
        this.votes = votes;
    }

    @Override
    public int compareTo(Candidate o) {
        return name.compareTo(o.getName());
    }
}
