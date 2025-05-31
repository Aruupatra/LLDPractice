package Swiggy.repositories;

import StackOverflow.User;
import Swiggy.models.Driver;

import java.util.HashMap;

public class UserRepository {

    HashMap<Integer, Driver> driverMap=new HashMap<>();

    public Driver saveDriver(Driver driver)
    {
         driver.setId(1);
         driverMap.put(1,driver);
         return driver;
    }
}
