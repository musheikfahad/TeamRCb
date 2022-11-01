package com.RCB;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

public class TestCAse1 {

	@Test

	public static void testForForiegnPlayers() throws IOException {
//		File jsonFile = new File("src/test/resources/RCB.json");
		
		String jsonFile ="{\r\n" + 
				"  \"name\": \"Royal Challengers Bangalore\",\r\n" + 
				"  \"location\": \"Bangalore\",\r\n" + 
				"  \"player\": [\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Faf Du Plessis\",\r\n" + 
				"      \"country\": \"South Africa\",\r\n" + 
				"      \"role\": \"Batsman\",\r\n" + 
				"      \"price-in-crores\": \"7\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Virat Kohli\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Batsman\",\r\n" + 
				"      \"price-in-crores\": \"15\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Glenn Maxwell\",\r\n" + 
				"      \"country\": \"Australia\",\r\n" + 
				"      \"role\": \"Batsman\",\r\n" + 
				"      \"price-in-crores\": \"11\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Mohammad Siraj\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Bowler\",\r\n" + 
				"      \"price-in-crores\": \"7\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Harshal Patel\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Bowler\",\r\n" + 
				"      \"price-in-crores\": \"10.75\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Wanindu Hasaranga\",\r\n" + 
				"      \"country\": \"Srilanka\",\r\n" + 
				"      \"role\": \"Bowler\",\r\n" + 
				"      \"price-in-crores\": \"10.75\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Dinesh Karthik\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Wicket-keeper\",\r\n" + 
				"      \"price-in-crores\": \"5.5\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Shahbaz Ahmed\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"All-Rounder\",\r\n" + 
				"      \"price-in-crores\": \"2.4\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Rajat Patidar\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Batsman\",\r\n" + 
				"      \"price-in-crores\": \"0.20\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Josh Hazlewood\",\r\n" + 
				"      \"country\": \"Australia\",\r\n" + 
				"      \"role\": \"Bowler\",\r\n" + 
				"      \"price-in-crores\": \"7.75\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"name\": \"Mahipal Lomror\",\r\n" + 
				"      \"country\": \"India\",\r\n" + 
				"      \"role\": \"Bowler\",\r\n" + 
				"      \"price-in-crores\": \"7.75\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		List<Object> players = JsonPath.read(jsonFile, "$.player[?(@.country!='India')]");

		System.out.println(players);

		int foriegn_players = players.size();

		assertEquals(4, foriegn_players);

	}

	@Test
	public static void NumOfWicketKeeper() throws IOException {

		File jsonFile = new File("src/test/resources/RCB.json");
		List<Object> Wk = JsonPath.read(jsonFile, "$.player[?(@.role=='Wicket-keeper')]");

		System.out.println(Wk);

		int wk_count = Wk.size();

		System.out.println(wk_count);

		boolean keeper = false;
		if (wk_count >= 1) {

			keeper = true;

		}

		assertTrue(keeper);
	}

}
