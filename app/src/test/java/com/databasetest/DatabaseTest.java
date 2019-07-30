package com.databasetest;

import com.databasetest.databaseClasses.StudentGroup;
import org.junit.*;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.Arrays;


@RunWith(RobolectricTestRunner.class)
public class DatabaseTest {

    private DBHelper databaseTest;

    @Before
    public void setup() {
        databaseTest = new DBHelper(RuntimeEnvironment.application);
    }

    @After
    public void complete() {
        databaseTest.close();
    }

    @Ignore("This test will be ignored")
    @Test
    public void testDbInsertion() {
        StudentGroup testGroup = new StudentGroup("ІВ-71", 2019, "ErA");
        StudentGroup testGroup2 = new StudentGroup("ІВ-72", 2019, "ErA");
        ArrayList<StudentGroup> groupsToInsert = new ArrayList<>(Arrays.asList(testGroup, testGroup2));

        databaseTest.addGroup(testGroup);
        databaseTest.addGroup(testGroup2);

        ArrayList<StudentGroup> studentGroupsInserted = databaseTest.getAllStudentGroups();

        Assert.assertEquals(groupsToInsert, studentGroupsInserted);
    }
}