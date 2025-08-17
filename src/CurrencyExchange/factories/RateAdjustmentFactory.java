package CurrencyExchange.factories;

import CurrencyExchange.RateAdjustmentType;

public class RateAdjustmentFactory {

    public static RateAdjustmentTypeFactory getRateAdjustmentTypeFactory(RateAdjustmentType rateAdjustmentType)
    {
        switch (rateAdjustmentType){
            case TRANSACTION_VOLUME :
                return new TransactionVolumeRateAdjustmentTypeFactory();
            case EXTERNAL_EXCHANGE_RATE:
                return new TransactionVolumeRateAdjustmentTypeFactory();
            default:
                return new TransactionVolumeRateAdjustmentTypeFactory();
        }
    }
}
