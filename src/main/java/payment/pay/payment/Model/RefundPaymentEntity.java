package payment.pay.payment.Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class RefundPaymentEntity {

	@Id
	@Type(type="uuid-char")
	@GenericGenerator(name="uuid",strategy="uuid2")
	@GeneratedValue(generator="uuid")
	private UUID refundpaymentId;
	
	@Column
	@Type(type="uuid-char")
	private UUID paymentId;
	
	@Column
	private String repaymentStatus;
	
	@Column
	private String totalAmount;
	
	@Column
	private String repaymentMode;
	
	@Column
	@Type(type="uuid-char")
	private UUID userId;
	
	@Column
	private Integer bookingId;

	public UUID getRefundpaymentId() {
		return refundpaymentId;
	}

	public void setRefundpaymentId(UUID refundpaymentId) {
		this.refundpaymentId = refundpaymentId;
	}

	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return repaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.repaymentStatus = paymentStatus;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return repaymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.repaymentMode = paymentMode;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	
}
