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
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true)
	private Long bookId;	
	
	private String title;
	
	private String isbm;

	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	@Column(nullable = false)
	private Date publicationYear;
	
	@Column(nullable = false)	
	@Min(value=0, message = "the quantity couldn´t less than zero")
	private int quantity;
	
//	@ManyToMany(mappedBy = "books")
//	private Set<Loan> loans = new HashSet<>();
	
	public Book() {
	}

	public Book(String title, String isbm, Publisher publisher, Category category, Author author, Date publicationYear, int quantity) {
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbm=" + isbm + ", publisher=" + publisher
				+ ", category=" + category + ", author=" + author + ", publicationYear=" + publicationYear
				+ ", quantity=" + quantity + "]";
	}	
}
