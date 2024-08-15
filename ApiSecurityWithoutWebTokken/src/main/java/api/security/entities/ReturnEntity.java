package api.security.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "returns")
public class ReturnEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique = true)
	private Long returnId;	
	
	@OneToOne
    @JoinColumn(name = "loan_id")
	private LoanEntity loan;
	
	private Date returnDate;
	
	@Column(precision = 3)
	private Float penalty;

	public ReturnEntity() {
	}	

	public ReturnEntity(LoanEntity loan, Date returnDate, Float penalty) {
		this.loan = loan;
		this.returnDate = returnDate;
		this.penalty = penalty;
	}

	public Date getreturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Float getPenalty() {
		return penalty;
	}

	public void setPenalty(Float penalty) {
		this.penalty = penalty;
	}

	public Long getReturnId() {
		return returnId;
	}

	public LoanEntity getLoan() {
		return loan;
	}

	public void setLoan(LoanEntity loan) {
		this.loan = loan;
	}

	public Date getReturnDate() {
		return returnDate;
	}	
	
	@Override
	public String toString() {
		return "Return [returnId=" + returnId + ", loan=" + loan + ", returnDate=" + returnDate + ", penalty=" + penalty
				+ "]";
	}
}
