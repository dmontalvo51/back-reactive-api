package dom.dmontalvo.bank.domain;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Diego Montalvo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateInfo {

    private CurrencyCode originCurrency;
    private CurrencyCode destinationCurrency;
    private BigDecimal originalAmount;
    private BigDecimal exchangedAmount;
    private BigDecimal exchangeRate;

    private LocalDateTime dateTime;

}
