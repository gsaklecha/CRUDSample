package com.sample.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Book entity
 * @author qe3nrt
 *
 */
@Entity
@Table(name="BOOK")
@NamedQuery(query = "select book from BookEntity book", name = "query_find_all_books")
public class BookEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7662657658328555403L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="version_id")
    private String versionId;
    
    @Column(name="book_name")
    private String bookName;
    
    @Column(name="author")
    private String author;
    
    @Column(name="book_content", nullable=false, length=500)
    private String bookContent;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the versionId
	 */
	public String getVersionId() {
		return versionId;
	}

	/**
	 * @param versionId the versionId to set
	 */
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the bookContent
	 */
	public String getBookContent() {
		return bookContent;
	}

	/**
	 * @param bookContent the bookContent to set
	 */
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", versionId=" + versionId + ", bookName=" + bookName + ", author=" + author
				+ ", bookContent=" + bookContent + "]";
	}
}