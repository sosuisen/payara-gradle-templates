package com.example;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.NoArgsConstructor;

/**
 * Jakarta RESTのリソースクラスです。
 * 
 * @Path はこのクラス全体が扱うURLのパスで、
 * @ApplicationPath からの相対パスとなります。
 * パスの先頭の/と末尾の/はあってもなくても同じです。
 */
@RequestScoped
@NoArgsConstructor(force = true)
@Path("/")
public class MyResources {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("messages")
	public List<String> messages() {
		return List.of("Hello", "World");
	}

}
