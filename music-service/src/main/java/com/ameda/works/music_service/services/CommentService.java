package com.ameda.works.music_service.services;


import com.ameda.works.music_service.model.Comment;

public interface CommentService {


     Comment create(Comment comment,String userId,String songId);
     Comment update(String id,Comment comment );
     void deleteById(String id);
}
