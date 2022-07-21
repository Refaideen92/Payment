package payment.pay.payment.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import payment.pay.payment.Model.PaymentEntity;
import payment.pay.payment.Model.RefundPaymentEntity;
import payment.pay.payment.Repository.PaymentRepository;
import payment.pay.payment.Repository.RefundPaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentrepo;

	@Autowired
	RefundPaymentRepository repaymentRepo;

	public PaymentEntity payPayment(PaymentEntity paymentEntity) {
		
		return paymentrepo.save(paymentEntity);
	}

	public ResponseEntity<?> refundPayment(UUID paymentId) {
		Optional<PaymentEntity> checkPayment = checkPayment(paymentId);
		if (checkPayment.isPresent()) {
			RefundPaymentEntity refundPayment = new RefundPaymentEntity();
			PaymentEntity paymentEntity = checkPayment.get();
			refundPayment.setPaymentId(paymentEntity.getPaymentId());
			refundPayment.setPaymentMode(paymentEntity.getPaymentMode());
			refundPayment.setPaymentStatus("In-progress");
			refundPayment.setTotalAmount(paymentEntity.getTotalAmount());
			refundPayment.setBookingId(paymentEntity.getBookingId());
			refundPayment.setUserId(paymentEntity.getUserId());
			repaymentRepo.save(refundPayment);
			paymentrepo.deleteById(paymentId);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(refundPayment);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Given payment Id does not exists!!");
		}
	}

	public Optional<PaymentEntity> checkPayment(UUID paymentId) {
		Optional<PaymentEntity> paymentDetail = paymentrepo.findById(paymentId);
		return paymentDetail;

	}
}
