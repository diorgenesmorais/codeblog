package com.example.codeblog.service;

import java.util.List;

import com.example.codeblog.model.Post;

public interface PostService {

	List<Post> findAll();

	Post findById(Integer id);

	Post save(Post post);
}
