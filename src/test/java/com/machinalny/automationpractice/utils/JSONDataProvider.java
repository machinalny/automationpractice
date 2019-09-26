package com.machinalny.automationpractice.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONDataProvider {
    public static String testCaseName = "NA";

    public JSONDataProvider() throws Exception {
    }

    @DataProvider(name = "fetchUser_JSON")
    public static Object[][] fetchData(Method method) throws Exception {
        Object rowID;
        Object[][] result;
        testCaseName = method.getName();
        List<JSONObject> testDataList = new ArrayList<>();
        JSONArray testData = MockarooClient.getUsers();
        for ( int i = 0; i < testData.length(); i++ ) {
            testDataList.add((JSONObject) testData.get(i));
        }

        // include Filter
        if ( System.getProperty("includePattern") != null ) {
            String include = System.getProperty("includePattern");
            List<JSONObject> newList = new ArrayList<JSONObject>();
            List<String> tests = Arrays.asList(include.split(",", -1));

            for ( String getTest : tests ) {
                for (JSONObject jsonObject : testDataList) {
                    if (jsonObject.toString().contains(getTest)) {
                        newList.add(jsonObject);
                    }
                }
            }

            // reassign testRows after filtering tests
            testDataList = newList;
        }

        // exclude Filter
        if ( System.getProperty("excludePattern") != null ) {
            String exclude =System.getProperty("excludePattern");
            List<String> tests = Arrays.asList(exclude.split(",", -1));

            for ( String getTest : tests ) {
                // start at end of list and work backwards so index stays in sync
                for ( int i = testDataList.size() - 1 ; i >= 0; i-- ) {
                    if ( testDataList.get(i).toString().contains(getTest) ) {
                        testDataList.remove(testDataList.get(i));
                    }
                }
            }
        }

        // create object for dataprovider to return
        try {
            result = new Object[testDataList.size()][testDataList.get(0).length()];

            for ( int i = 0; i < testDataList.size(); i++ ) {
                rowID = testDataList.get(i).get("rowID").toString();
                result[i] = new Object[] { rowID, testDataList.get(i) };
            }
        }

        catch(IndexOutOfBoundsException ie) {
            result = new Object[0][0];
        }

        return result;
    }
}
