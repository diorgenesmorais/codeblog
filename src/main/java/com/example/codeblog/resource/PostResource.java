package com.example.codeblog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblog.model.Post;
import com.example.codeblog.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping
	public List<Post> listar() {
		return postService.findAll();
	}

	@GetMapping("/{id}")
	public Post buscarPorId(@PathVariable Integer id) {
		return postService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Post> salvar(@RequestBody Post post) {
		Post posted = postService.save(post);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(posted);
	}
}
