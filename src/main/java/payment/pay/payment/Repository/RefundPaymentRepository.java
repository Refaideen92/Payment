package payment.pay.payment.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import payment.pay.payment.Model.RefundPaymentEntity;

public interface RefundPaymentRepository extends JpaRepository<RefundPaymentEntity, UUID>{

}
