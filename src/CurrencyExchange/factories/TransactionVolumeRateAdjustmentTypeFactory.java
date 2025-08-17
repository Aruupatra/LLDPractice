package CurrencyExchange.factories;

import CurrencyExchange.AddCurrencyDto;
import CurrencyExchange.Currency;
import CurrencyExchange.RateCalculationType;

public class TransactionVolumeRateAdjustmentTypeFactory implements RateAdjustmentTypeFactory {
    @Override
    public AddCurrencyDto calculateRate(Currency from, Currency to, double amount, double rate, RateCalculationType rateCalculationType) {

        RateCaculationType rateCaculationType= RateCalculationTypeFactory.getRateCalculationTypeInstance(rateCalculationType);
        double newRate=rateCaculationType.CalculateRate(rate);
        return null;
    }
}
