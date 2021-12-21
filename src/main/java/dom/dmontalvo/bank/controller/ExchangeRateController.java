package dom.dmontalvo.bank.controller;

import com.neovisionaries.i18n.CurrencyCode;
import dom.dmontalvo.bank.domain.ExchangeRateInfo;
import dom.dmontalvo.bank.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Diego Montalvo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateService service;

    @GetMapping
    public ExchangeRateInfo getExchangeRate(@RequestParam(value = "amount") BigDecimal amount,
                                            @RequestParam(value = "from") CurrencyCode fromCurrency,
                                            @RequestParam(value = "to") CurrencyCode toCurrency) {
        return service.getExchangeRateInfo(ExchangeRateInfo.builder()
                .originalAmount(amount)
                .originCurrency(fromCurrency)
                .destinationCurrency(toCurrency)
                .build()).toBlocking().single();
    }

}
