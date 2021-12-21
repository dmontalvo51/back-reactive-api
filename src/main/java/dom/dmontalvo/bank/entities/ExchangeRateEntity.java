package dom.dmontalvo.bank.entities;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Diego Montalvo
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateEntity {

    private @Id
    @GeneratedValue
    Long id;

    private CurrencyCode origin;
    private CurrencyCode destination;
    private BigDecimal buyingExchangeRate; //origin to destination
    private BigDecimal sellingExchangeRate; //destination to origin


}
