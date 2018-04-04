package org.koushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messanger.model.Comment;
import org.koushik.javabrains.messanger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService cs = new CommentService();

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return cs.getAllComments(messageId);
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return cs.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, Comment comment) {
		return cs.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public void updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		cs.deleteComment(messageId, commentId);
	}

}
