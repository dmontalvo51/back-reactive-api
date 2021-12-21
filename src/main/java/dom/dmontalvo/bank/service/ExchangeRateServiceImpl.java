package dom.dmontalvo.bank.service;

import com.neovisionaries.i18n.CurrencyCode;
import dom.dmontalvo.bank.domain.ExchangeRateInfo;
import dom.dmontalvo.bank.domain.ExchangeRates;
import dom.dmontalvo.bank.entities.ExchangeRateEntity;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * @author Diego Montalvo
 */
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Override
    public Observable<ExchangeRateInfo> getExchangeRateInfo(ExchangeRateInfo request) {
        try {
            return Observable.just(buildExchangeRateResponse(request));
        } catch (NoSuchAlgorithmException e) {
            return Observable.error(e);
        }

    }

    @Override
    public Observable<ExchangeRateInfo> updateExchangeRate(ExchangeRates request) {
        return null;
    }

    private ExchangeRateInfo buildExchangeRateResponse(ExchangeRateInfo request) throws NoSuchAlgorithmException {

        ExchangeRateEntity entity = retrieveExchangeRate(request.getOriginCurrency(), request.getDestinationCurrency());

        //TODO improve exchange logic
        BigDecimal exchangedAmount = request.getOriginalAmount().multiply(entity.getBuyingExchangeRate());

        return ExchangeRateInfo.builder()
                .originCurrency(request.getOriginCurrency())
                .destinationCurrency(request.getDestinationCurrency())
                .originalAmount(request.getOriginalAmount())
                .exchangedAmount(exchangedAmount)
                .exchangeRate(entity.getBuyingExchangeRate())
                .build();
    }

    private ExchangeRateEntity retrieveExchangeRate(CurrencyCode origin, CurrencyCode destination) throws NoSuchAlgorithmException {

        Boolean whichOne = SecureRandom.getInstanceStrong().nextBoolean();

        if (whichOne)
            //todo retrieve from database
            return ExchangeRateEntity.builder()
                    .origin(origin)
                    .destination(destination)
                    .buyingExchangeRate(new BigDecimal("3.9"))
                    .sellingExchangeRate(new BigDecimal("3.8")).build();
        else
            return ExchangeRateEntity.builder()
                    .origin(origin)
                    .destination(destination)
                    .buyingExchangeRate(new BigDecimal("4.1"))
                    .sellingExchangeRate(new BigDecimal("4.0")).build();
    }


}
