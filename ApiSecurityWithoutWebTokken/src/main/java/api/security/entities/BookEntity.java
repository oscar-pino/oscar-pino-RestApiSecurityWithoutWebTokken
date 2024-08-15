package api.security.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "books")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true)
	private Long bookId;	
	
	@Column(nullable = false)	
	private String title;
	
	@Column(nullable = false, unique = true)
	private String isbm;

	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private PublisherEntity publisher;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private AuthorEntity author;
	
	@Column(nullable = false)
	private Date publicationYear;
	
	@Column(nullable = false)	
	@Min(value=0, message = "the quantity couldn´t less than zero")
	private int quantity;
	
//	@ManyToMany(mappedBy = "books")
//	private Set<Loan> loans = new HashSet<>();
	
	public BookEntity() {
	}

	public BookEntity(String title, String isbm, PublisherEntity publisher, CategoryEntity category, AuthorEntity author, Date publicationYear, int quantity) {
	this.title = title;
	this.isbm = isbm;
	this.publisher = publisher;
	this.category = category;
	this.author = author;
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

	public PublisherEntity getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public AuthorEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbm=" + isbm + ", publisher=" + publisher
				+ ", category=" + category + ", author=" + author.getFirstName() + ", publicationYear=" + publicationYear
				+ ", quantity=" + quantity + "]";
	}	
}
