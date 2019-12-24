package com.example.codeblog.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

import com.example.codeblog.BaseTest;
import com.example.codeblog.LocalDateAdapter;
import com.example.codeblog.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
				.body("data", is("2019-12-19"))
			;
	}
	
	@Test
	public void deveSalvarUmPost() throws Exception {
	
		Post post = new Post();
		post.setAutor("Laudeci Morais");
		post.setTitulo("OAUTH");
		post.setData(LocalDate.now());
		post.setTexto("OAuth é um padrão aberto para autorização, comumente utilizado para permitir que os usuários da Internet possam fazer logon em sites de terceiros usando suas contas do Google, Facebook, Microsoft, Twitter, etc.—mas, sem expor suas senhas. Geralmente, o OAuth fornece aos clientes um \"acesso seguro delegado\" aos recursos do servidor em nome do proprietário do recurso. Ele especifica um processo para proprietários de recursos para autorizar o acesso de terceiros aos seus recursos de servidor sem compartilhar suas credenciais. Projetado especificamente para trabalhar com o Protocolo de Transferência de Hipertexto (HTTP), o OAuth permite essencialmente tokens de acesso a ser emitidos para clientes de terceiros, mediante autorização do servidor, com a aprovação do proprietário do recurso. O terceiro, em seguida, usa o token de acesso para recursos protegidos hospedados pelo servidor.");
		
		Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
							.create();

		String json = gson.toJson(post);

		RestAssured.given()
					.contentType(ContentType.JSON)
					.body(json)
					.log().body()
				.when()
					.post("/posts")
				.then()
					.log().all()
					.assertThat().statusCode(201);
	}
}
