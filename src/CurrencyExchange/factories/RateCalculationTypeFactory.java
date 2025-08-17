package CurrencyExchange.factories;

import CurrencyExchange.RateAdjustmentType;
import CurrencyExchange.RateCalculationType;

public class RateCalculationTypeFactory {

   public static RateCaculationType getRateCalculationTypeInstance(RateCalculationType type)
    {
        switch (type)
        {
            case RateCalculationType.FACTOR_MULTIPLIER:
                return new FactorMultiplierRateCalculationType();
            default:
                return new FactorMultiplierRateCalculationType();

        }
    }
}
