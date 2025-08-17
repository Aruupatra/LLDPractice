package CurrencyExchange;

import CurrencyExchange.strategies.PathFindingStrategy;
import CurrencyExchange.strategies.ShortestPath;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class CurrencyExchange {

      static  CurrencyExchange currencyExchange;
      HashMap<Currency,HashMap<Currency,Double>> graph;
      LinkedBlockingDeque<AddCurrencyDto> queue;
      ExecutorService executorService;
      PathFindingStrategy pathFindingStrategy;

      CurrencyExchange()
      {
          graph=new HashMap<>();
          queue=new LinkedBlockingDeque<>();
          executorService= Executors.newFixedThreadPool(5);
          pathFindingStrategy=new ShortestPath();

          for(int i=0;i<5;i++)
          {
              executorService.submit(this::exexute);
          }
      }

      AddCurrencyDto transact(Currency from,Currency to,double amount)
      {
          if(graph.containsKey(from) && graph.get(from).containsKey(to))
          {
              double amountt=amount * graph.get(from).get(to);
               return AddCurrencyDto.builder()
                  .from(from)
                  .to(to)
                  .amount(amountt)
                  .build();
          }
          if(graph.containsKey(to) && graph.get(from).containsKey(from))
          {
              double amountt=1.0/(amount * graph.get(to).get(from));
              return AddCurrencyDto.builder()
                      .from(from)
                      .to(to)
                      .amount(amountt)
                      .build();
          }

          Optional<Double> rate=pathFindingStrategy.getCost(graph,from,to);
          AddCurrencyDto addCurrencyDto=null;

          if(rate.isPresent()){
              addCurrencyDto=AddCurrencyDto.builder().from(from).to(to).amount(amount*rate.get()).build();
              queue.add(addCurrencyDto);
              return addCurrencyDto;
          }

          Optional<Double> rate2=pathFindingStrategy.getCost(graph,to,from);
          if(rate2.isEmpty())
          {
              throw new IllegalStateException("Conversion is Not possible at this Moment");
          }

          addCurrencyDto=AddCurrencyDto.builder().from(from).to(to).amount(amount*(1.0/rate.get())).build();
          return addCurrencyDto;
      }


      public void exexute()
      {
          AddCurrencyDto addCurrencyDTO=queue.poll();
          updateGraph(addCurrencyDTO);
      }

      public void updateGraph(AddCurrencyDto addCurrencyDto)
      {
          Currency from= addCurrencyDto.from;
          if(!graph.containsKey(from))
          {
              graph.put(from,new HashMap<>());
          }
          graph.get(from).put(addCurrencyDto.to, addCurrencyDto.rate);
      }



}
