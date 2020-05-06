/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.geocode;

import com.donatedrop.geocode.Dao_GeoCode_I;

import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.geocode.models.DivisionsEngName;
import com.donatedrop.geocode.models.UnionsEngName;
import com.donatedrop.geocode.models.UpzillaEngName;
import com.donatedrop.other.DumpData;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.Utils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

/**
 * @author G7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_Dao_GEO_Code {

    @Autowired
    private Dao_GeoCode_I dao_GeoCode_I;

    public Test_Dao_GEO_Code() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_GetDivisions() {
        dao_GeoCode_I.getDivisions().forEach(o -> System.out.println(o));
        int divisions = dao_GeoCode_I.getDivisions().size();
        assertEquals(divisions, 8);
    }

    @Test
    public void test_getDistricts() {
        String divID = "3"; //khulna, id=3 has 10 districts
        dao_GeoCode_I.getDistricts(divID).forEach(o -> System.out.println(o));
        int districts = dao_GeoCode_I.getDistricts(divID).size();
        assertEquals(districts, 10);
    }

    @Test
    public void test_getUpzillas() {
        String distID = "27";//khulna, id=27 has 9 districts
        dao_GeoCode_I.getUpzillas(distID).forEach(o -> System.out.println(o));
        int upzillas = dao_GeoCode_I.getUpzillas(distID).size();
        assertEquals(upzillas, 9);
    }

    @Test
    public void test_getUnions() {
        String upzID = "211";//Dumuria, id=211 has 14 unions
        dao_GeoCode_I.getUnions(upzID).forEach(o -> System.out.println(o));
        int upzillas = dao_GeoCode_I.getUnions(upzID).size();
        assertEquals(upzillas, 14);
    }


//    @org.junit.jupiter.api.Test
//    public void testAddress() {
//        for (int x = 0; x < 50; x++) {
//            System.out.println(getAddress());
//        }
//    }
//
//    public String getAddress() {
//        Random r = new Random();
//        System.out.println("\n" + dao_GeoCode_I.toString() + "\n");
//
//        List<DivisionsEngName> divisionsList = dao_GeoCode_I.getDivisions();
//        int divRand = r.nextInt(divisionsList.size());
//        String divID = divisionsList.get(divRand).getId().toString();
//        String divName = divisionsList.get(divRand).getName().toString();
//
//        List<DistrictsEngName> districtsEngNameList = dao_GeoCode_I.getDistricts(divID);
//        int distRand = r.nextInt(districtsEngNameList.size());
//        String distID = districtsEngNameList.get(distRand).getId().toString();
//        String distName = districtsEngNameList.get(distRand).getName().toString();
//
//        List<UpzillaEngName> upzillaEngNameList = dao_GeoCode_I.getUpzillas(distID);
//        int upzRand = r.nextInt(upzillaEngNameList.size());
//        String upzID = upzillaEngNameList.get(upzRand).getId().toString();
//        String upzName = upzillaEngNameList.get(upzRand).getName().toString();
//
//        List<UnionsEngName> unionsEngNameList = dao_GeoCode_I.getUnions(upzID);
//        int unionRand = r.nextInt(unionsEngNameList.size());
//        String unionID = unionsEngNameList.get(unionRand).getId().toString();
//        String unionName = unionsEngNameList.get(unionRand).getName().toString();
//
//        return unionName + ", " + upzName + ", " + distName + ", " + divName;
//    }


}
