package com.example.codeblog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.codeblog.model.Post;
import com.example.codeblog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(Integer id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return post.get();
	}

	@Transactional
	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

}
