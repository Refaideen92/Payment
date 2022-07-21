package payment.pay.payment.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import payment.pay.payment.Model.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID>{
	

}
