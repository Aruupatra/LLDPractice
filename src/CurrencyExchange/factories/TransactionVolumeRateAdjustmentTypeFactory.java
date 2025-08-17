package CurrencyExchange.factories;

import CurrencyExchange.Currency;
import CurrencyExchange.RateCalculationType;

public class TransactionVolumeRateAdjustmentTypeFactory implements RateAdjustmentTypeFactory {
    @Override
    public AddCurrencyDTO calculateRate(Currency from, Currency to, double amount, double rate, RateCalculationType rateCalculationType) {

        RateCaculationType rateCaculationType= RateCalculationTypeFactory.getRateCalculationTypeInstance(rateCalculationType);
        double newRate=rateCaculationType.CalculateRate(rate);
        return null;
    }
}
