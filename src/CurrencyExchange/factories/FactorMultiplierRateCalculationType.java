package CurrencyExchange.factories;

public class FactorMultiplierRateCalculationType implements RateCaculationType{
    @Override
    public double CalculateRate(double rate) {
        return 1.02*rate;
    }
}
