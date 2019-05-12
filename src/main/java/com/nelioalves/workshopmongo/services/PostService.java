package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitleContaining(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> searchTitle(String text){
		return postRepository.searchTitle(text);
	}

}
