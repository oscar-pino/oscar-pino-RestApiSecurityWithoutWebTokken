package api.security.dto;

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

public class LoanDTO {

	private Long loanId;

	private Set<BookDTO> books = new HashSet<>();

	private CustomerDTO customer;
	
	private Date loanDate;
	
	private Date deliverDate;
	
	private String status;	

	private ReturnDTO returnDTO;

	public LoanDTO() {
	}	

	public LoanDTO(Set<BookDTO> books, CustomerDTO customer, Date loanDate, Date deliverDate, String status) {
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
	
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Set<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(Set<BookDTO> books) {
		this.books = books;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}	

	public ReturnDTO getReturnDTO() {
		return returnDTO;
	}

	public void setReturnDTO(ReturnDTO returnDTO) {
		this.returnDTO = returnDTO;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", books=" + books + ", customer=" + customer + ", loanDate=" + loanDate
				+ ", deliverDate=" + deliverDate + ", status=" + status + "]";
	}
}
