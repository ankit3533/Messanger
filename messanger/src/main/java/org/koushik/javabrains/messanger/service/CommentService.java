package org.koushik.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messanger.database.DatabaseClass;
import org.koushik.javabrains.messanger.model.Comment;
import org.koushik.javabrains.messanger.model.Message;

public class CommentService {

	private static final Comment comment = null;
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());

	}
	
	public Comment getComment(long messageId, long commentId) {
		return messages.get(messageId).getComments().get(commentId);

	}
	public Comment addComment(long messageId, Comment comment) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size());
		comments.put(comment.getId(), comment);
		return comment;
	}
	public void deleteComment(long messageId, long commentId) {
		messages.get(messageId).getComments().remove(commentId);

	}
	public Comment updateComment(long messageId, Comment comment) {
		if(comment.getId()<=0)
			return null;
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;

	}
	

	
}
