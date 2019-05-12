package com.nelioalves.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.resources.util.URL;
import com.nelioalves.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value="text",defaultValue="") String text){
		List<Post> posts = postService.findByTitleContaining(URL.decodeParam(text));
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value="/titlequerysearch")
	public ResponseEntity<List<Post>> searchTitle(@RequestParam(value="text",defaultValue="") String text){
		List<Post> posts = postService.searchTitle(URL.decodeParam(text));
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			                                     @RequestParam(value="text",defaultValue="") String text, 
			                                     @RequestParam(value="minDate") String dateMin,  
			                                     @RequestParam(value="maxDate") String dateMax
			                                    )
	{
		List<Post> posts = postService.fullSearch(URL.decodeParam(text),URL.convertDate(dateMin, new Date(0L)),URL.convertDate(dateMax, new Date()));
		return ResponseEntity.ok().body(posts);
	}
	

}
