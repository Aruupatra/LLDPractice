package CurrencyExchange;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddCurrencyDto {

    Currency from;
    Currency to;
    double rate;
    double amount;


}
