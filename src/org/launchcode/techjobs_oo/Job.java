package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Employer getEmployer() {
        return this.employer;
    }

    public Location getLocation() {
        return this.location;
    }

    public CoreCompetency getCoreCompetency() {
        return this.coreCompetency;
    }

    public PositionType getPositionType() {
        return this.positionType;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }


//blank line before and after Job info
//one field / line, string should have label for each field with its data
//empty field - "data not available" after label
//if Job obj only contains data for id field, "oops this job does not seem to exist"

    @Override
    public String toString() {
        String nameString = this.name;
        String employerString = this.employer.toString();
        String locationString = this.location.toString();
        String positionTypeString = this.positionType.toString();
        String coreCompetencyString = this.coreCompetency.toString();

        if (this.name.equals("") && this.employer.getValue().equals("") && this.location.getValue().equals("") &&
                this.positionType.getValue().equals("")
                && this.coreCompetency.getValue().equals("")) {
            return "OOPS! This job does not seem to exist.";
        }

        if(this.name.equals("")) {
            nameString = "Data not available";
        }

        if(this.employer.getValue().equals("")) {
            employerString = "Data not available";
        }

        if(this.location.getValue().equals("")) {
            locationString = "Data not available";
        }

        if(this.positionType.getValue().equals("")) {
            positionTypeString = "Data not available";
        }

        if(this.coreCompetency.getValue().equals("")) {
            coreCompetencyString = "Data not available";
        }

        return "\nID: " + this.id + "\nName: " + nameString +
                "\nEmployer: " + employerString +
                "\nLocation: " + locationString +
                "\nPosition Type: " + positionTypeString +
                "\nCore Competency: " + coreCompetencyString +
                "\n";
    }



}
