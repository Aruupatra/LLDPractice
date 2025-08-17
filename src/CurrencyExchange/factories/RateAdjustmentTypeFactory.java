package CurrencyExchange.factories;

import CurrencyExchange.AddCurrencyDto;
import CurrencyExchange.Currency;
import CurrencyExchange.RateCalculationType;

public interface RateAdjustmentTypeFactory {

    AddCurrencyDto calculateRate(Currency from, Currency to, double amount, double rate, RateCalculationType rateCalculationType);
}
