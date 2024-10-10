package api.security.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class LoanEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "loan_id", nullable=false, unique = true)
	private Long loanId;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "loans_books",
               joinColumns = @JoinColumn(name = "loan_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<BookEntity> books;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;
	
	private LocalDate loanDate;
	
	private LocalDate deliverDate;
	
	private String status;	
	
	@OneToOne(mappedBy = "loan")
	private ReturnEntity returns;

	public LoanEntity() {
	}	

	public LoanEntity(List<BookEntity> books, CustomerEntity customer, LocalDate loanDate, LocalDate deliverDate, String status) {
		this.books = books;
		this.customer = customer;
		this.loanDate = loanDate;
		this.deliverDate = deliverDate;
		this.status = status;
	}



	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(LocalDate deliverDate) {
		this.deliverDate = deliverDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getLoanId() {
		return loanId;
	}

	public List<BookEntity> getBooks() {
		return books;
	}	

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId +", customer=" + customer.getFirstName() + ", loanDate=" + loanDate
				+ ", deliverDate=" + deliverDate + ", status=" + status + "]";
	}
}
