package CurrencyExchange.strategies;

import CurrencyExchange.Currency;

import java.util.HashMap;
import java.util.Optional;

public class ShortestPath implements PathFindingStrategy{
    @Override
    public Optional<Double> getCost(HashMap<Currency, HashMap<Currency, Double>> graph, Currency from, Currency to) {

        //logic to find shortest Path
        return Optional.of(0.0);
    }
}
