package io.turntabl.tcms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void testDistance(){
        assertEquals(3, Utils.lavenstine("Flomax", "Volmax"));
    }

    @Test
    public void testDistance2(){
        assertEquals(4, Utils.lavenstine("Dennis", "Bernice"));
    }

    @Test
    public void testReadingDataFromFile(){
        System.out.println(Utils.readFromFile());
    }
       @Test
    public void testMatchingStrings() {
//        assertEquals(Arrays.asList(c),Utils.searchByName("Dennis"));
           try {
               assertNotEquals("Dennis",Utils.searchByName("as"));
           } catch (Exception clientNotFound) {
               clientNotFound.getMessage();
           }
       }
       @Test
    public void testFirstName(){
        assertEquals("Dennis", Utils.firstWord("Dennis Effa"));
       }
       @Test
    public void duplicateUser(){
           Client cc = new Client("234","Dennis","123","abc","abc");
           try{
               System.out.println(Utils.duplicateUser(cc));
           } catch (DuplicateClienException e) {
               e.getMessage();
           }
       }
}