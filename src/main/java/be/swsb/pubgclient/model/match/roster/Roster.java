package be.swsb.pubgclient.model.match.roster;

import be.swsb.pubgclient.model.match.ParticipantRosterAsset;
import com.google.gson.annotations.SerializedName;

public class Roster implements ParticipantRosterAsset {

    private String id;
    @SerializedName("attributes")
    private RosterAttributes rosterAttributes;
    @SerializedName("relationships")
    private RosterRelationships rosterRelationships;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RosterAttributes getRosterAttributes() {
        return rosterAttributes;
    }

    public void setRosterAttributes(RosterAttributes rosterAttributes) {
        this.rosterAttributes = rosterAttributes;
    }

    public RosterRelationships getRosterRelationships() {
        return rosterRelationships;
    }

    public void setRosterRelationships(RosterRelationships rosterRelationships) {
        this.rosterRelationships = rosterRelationships;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id='" + id + '\'' +
                ", rosterAttributes=" + rosterAttributes +
                ", rosterRelationships=" + rosterRelationships +
                '}';
    }
}
