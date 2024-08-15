package api.security.dto;

import java.util.Date;

public class ReturnDTO {

	private Long returnId;	

	private LoanDTO loanDTO;
	
	private Date returnDate;

	private Float penalty;

	public ReturnDTO() {
	}	

	public ReturnDTO(LoanDTO loanDTO, Date returnDate, Float penalty) {
		this.loanDTO = loanDTO;
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

	public LoanDTO getLoan() {
		return loanDTO;
	}

	public void setLoan(LoanDTO loanDTO) {
		this.loanDTO = loanDTO;
	}

	public Date getReturnDate() {
		return returnDate;
	}	
	
	@Override
	public String toString() {
		return "Return [returnId=" + returnId + ", returnDate=" + returnDate + ", penalty=" + penalty
				+ "]";
	}
}
