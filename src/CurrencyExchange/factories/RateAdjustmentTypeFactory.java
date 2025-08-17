package CurrencyExchange.factories;

import CurrencyExchange.Currency;
import CurrencyExchange.RateCalculationType;

public interface RateAdjustmentTypeFactory {

    AddCurrentDTO calculateRate(Currency from, Currency to, double amount, double rate, RateCalculationType rateCalculationType);
}
