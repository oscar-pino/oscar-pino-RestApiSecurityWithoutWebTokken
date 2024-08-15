package api.security.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @JoinTable(name = "loan_book",
               joinColumns = @JoinColumn(name = "loan_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
	private Set<BookEntity> books = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;
	
	private Date loanDate;
	
	private Date deliverDate;
	
	private String status;	
	
	@OneToOne(mappedBy = "loan")
	private ReturnEntity returns;

	public LoanEntity() {
	}	

	public LoanEntity(Set<BookEntity> books, CustomerEntity customer, Date loanDate, Date deliverDate, String status) {
		this.books = books;
		this.customer = customer;
		this.loanDate = loanDate;
		this.deliverDate = deliverDate;
		this.status = status;
	}



	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
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

	public Set<BookEntity> getBooks() {
		return books;
	}	

	public void setBooks(Set<BookEntity> books) {
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
