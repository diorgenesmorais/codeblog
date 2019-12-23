package com.example.codeblog.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.example.codeblog.BaseTest;

import io.restassured.RestAssured;

public class PostResourceTest extends BaseTest {

	@Test
	public void deveObterUmaListaPost() throws Exception {
		RestAssured.given()
			.pathParam("resource", "posts")
		.when()
			.get("/{resource}")
		.then().assertThat().statusCode(200)
			.time(Matchers.lessThan(1500L))
			.and()
			.body("titulo", Matchers.hasItem("Docker"))
		;
	}
	
	@Test
	public void deveObterUmPost() throws Exception {
		RestAssured.given()
			.when()
				.get("/posts/2")
			.then()
				.assertThat().statusCode(200)
				.and()
				.body("titulo", is("REST"))
				.and()
				.body("data", is("19-12-2019"))
			;
	}
}
