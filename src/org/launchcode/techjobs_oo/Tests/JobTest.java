package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;
//* imports all classes within package, look at Assert


public class JobTest {

    private Job firstJob;
    private Job secondJob;
    private Job jobFullConstructor;
    private Job jobFullConstructor2;
    private Job onlyLocationData;
    private Job locationEmptyField;
    private Job onlyIdHasData;

    @Before
    public void createJobObjects() {
        firstJob = new Job();
        secondJob = new Job();
        jobFullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFullConstructor2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        onlyLocationData = new Job("", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        locationEmptyField = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        onlyIdHasData = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));


    }

    @Test
    public void testSettingJobId() {
        assertEquals(firstJob.getId() + 1, secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", jobFullConstructor.getName());
        assertEquals("ACME", jobFullConstructor.getEmployer().toString());
        assertTrue(jobFullConstructor.getEmployer() instanceof Employer);
        assertEquals("Desert", jobFullConstructor.getLocation().toString());
        assertTrue(jobFullConstructor.getLocation() instanceof Location);
        assertEquals("Quality control", jobFullConstructor.getPositionType().toString());
        assertTrue(jobFullConstructor.getPositionType() instanceof PositionType);
        assertEquals("Persistence", jobFullConstructor.getCoreCompetency().toString());
        assertTrue(jobFullConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(jobFullConstructor.equals(jobFullConstructor2));
    }

    @Test
    public void blankLineBeforeAndAfterJobInfo() {
        int length = jobFullConstructor.toString().length();
        assertEquals('\n', jobFullConstructor.toString().charAt(0));
        assertEquals('\n', jobFullConstructor.toString().charAt(length - 1));
    }

    @Test
    public void eachFieldHasDataAndSeparateLine() {
        assertEquals("\nID: " + jobFullConstructor.getId()+ "\nName: Product tester\nEmployer: ACME" +
                "\nLocation: Desert" + "\nPosition Type: Quality control\nCore Competency: Persistence\n",
                jobFullConstructor.toString());
    }

    @Test
    public void testLocationDataOnly() {
        assertEquals("\nID: " + onlyLocationData.getId()+ "\nName: Data not available\nEmployer: Data not available" +
                "\nLocation: Desert" + "\nPosition Type: Data not available\nCore Competency: Data not available\n",onlyLocationData.toString());
    }


    @Test
    public void emptyStringInField() {
        assertEquals("\nID: " + locationEmptyField.getId()+ "\nName: Product tester\nEmployer: ACME" +
                "\nLocation: Data not available" + "\nPosition Type: Quality control\nCore Competency: Persistence\n", locationEmptyField.toString());

    }

    @Test
    public void testIdHasDataOnly() {
        assertEquals("OOPS! This job does not seem to exist.", onlyIdHasData.toString());
    }

    }
