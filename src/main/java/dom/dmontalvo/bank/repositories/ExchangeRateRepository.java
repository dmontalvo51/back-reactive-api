package dom.dmontalvo.bank.repositories;

import dom.dmontalvo.bank.entities.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Diego Montalvo
 */
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {



}
