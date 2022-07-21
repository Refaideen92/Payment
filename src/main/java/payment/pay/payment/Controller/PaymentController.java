package payment.pay.payment.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payment.pay.payment.Model.PaymentEntity;
import payment.pay.payment.Service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/pay")
	public PaymentEntity getProceedPayment(@RequestBody PaymentEntity paymentEntity) {
		return paymentService.payPayment(paymentEntity);
	}
	
	@PostMapping("/refund")
	public ResponseEntity<?> getProceedRePayment(@RequestBody UUID paymentId) {
		return paymentService.refundPayment(paymentId);
	}
}
