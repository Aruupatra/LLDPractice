package CurrencyExchange.strategies;

import CurrencyExchange.Currency;

import java.util.HashMap;
import java.util.Optional;

public interface PathFindingStrategy {


    public Optional<Double> getCost(HashMap<Currency,HashMap<Currency,Double>> graph, Currency from , Currency to);
}
