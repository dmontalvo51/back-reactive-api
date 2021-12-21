package dom.dmontalvo.bank.domain;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Diego Montalvo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRates {

    private CurrencyCode originCurrency;
    private CurrencyCode destinationCurrency;
    private BigDecimal buyingAmount;
    private BigDecimal sellingAmount;


}
