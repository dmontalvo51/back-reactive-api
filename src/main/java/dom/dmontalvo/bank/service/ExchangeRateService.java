package dom.dmontalvo.bank.service;

import dom.dmontalvo.bank.domain.ExchangeRateInfo;
import dom.dmontalvo.bank.domain.ExchangeRates;
import rx.Observable;
import rx.Single;

/**
 * @author Diego Montalvo
 */
public interface ExchangeRateService {

    Observable<ExchangeRateInfo> getExchangeRateInfo(ExchangeRateInfo request);


    Observable<ExchangeRateInfo> updateExchangeRate(ExchangeRates request);


}
