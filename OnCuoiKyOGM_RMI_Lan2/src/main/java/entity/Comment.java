package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2154503092948773495L;
	private String commentContent;
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(columnDefinition = "newsId")
	private News nw;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentContent, LocalDateTime date) {
		super();
		this.commentContent = commentContent;
		this.date = date;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public News getNw() {
		return nw;
	}

	public void setNw(News nw) {
		this.nw = nw;
	}

	@Override
	public String toString() {
		return "Comment [commentContent=" + commentContent + ", date=" + date + ", nw=" + nw + "]";
	}
	
	
}
