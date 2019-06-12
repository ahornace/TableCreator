package cz.cuni.mff.tablecreator;

import org.junit.Test;

import javax.persistence.*;

import static org.junit.Assert.assertEquals;

public class TableCreatorTest {

    private static class NonEntityClass {

    }

    @Entity
    private static class User {

        @Id
        @GeneratedValue
        private long id;

        @Column(nullable = false)
        public String name;
        private String password;

    }

    @Entity(name = "records")
    private static class MedicalRecords {

        private static final int INSURANCE_NUMBER_SIZE = 48;

        protected String name;

        @Column(name = "inNum", length = INSURANCE_NUMBER_SIZE)
        private String insuranceNumber;

        @Transient
        private String illness;

        int age;

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonEntityClass() {
        TableCreator.process(NonEntityClass.class);
    }

    @Test
    public void testUserEntity() {
        assertEquals("CREATE TABLE User(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, password VARCHAR(255));", TableCreator.process(User.class));
    }

    @Test
    public void testMedicalRecordsEntity() {
        assertEquals("CREATE TABLE records(name VARCHAR(255), inNum VARCHAR(48), age INTEGER);", TableCreator.process(MedicalRecords.class));
    }

}