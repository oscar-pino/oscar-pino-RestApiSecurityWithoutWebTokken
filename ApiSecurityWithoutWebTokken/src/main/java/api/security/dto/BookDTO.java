package api.security.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookDTO {

	private Long bookId;	
	
	private String title;
	
	private String isbm;

	private PublisherDTO PublisherDTO;

	private CategoryDTO categoryDTO;

	private AuthorDTO authorDTO;

	private Date publicationYear;

	private int quantity;

	
	public BookDTO() {
	}

	public BookDTO(String title, String isbm, PublisherDTO PublisherDTO, CategoryDTO category, AuthorDTO author, Date publicationYear, int quantity) {
	this.title = title;
	this.isbm = isbm;
	this.PublisherDTO = PublisherDTO;
	this.categoryDTO = category;
	this.authorDTO = author;
	this.publicationYear = publicationYear;
	this.quantity = quantity;
}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbm() {
		return isbm;
	}

	public void setIsbm(String isbm) {
		this.isbm = isbm;
	}

	public Date getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Date publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Long getBookId() {
		return bookId;
	}
	
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public PublisherDTO getPublisherDTO() {
		return PublisherDTO;
	}

	public void setPublisherDTO(PublisherDTO PublisherDTO) {
		this.PublisherDTO = PublisherDTO;
	}

	public CategoryDTO getCategory() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbm=" + isbm + ", PublisherDTO=" + PublisherDTO
				+ ", category=" + categoryDTO + ", author=" + authorDTO + ", publicationYear=" + publicationYear
				+ ", quantity=" + quantity + "]";
	}	
}
