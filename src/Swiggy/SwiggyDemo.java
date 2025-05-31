package Swiggy;

import Swiggy.controllers.UserController;
import Swiggy.exceptions.LicenseInvalidException;
import Swiggy.models.Driver;
import Swiggy.repositories.UserRepository;
import Swiggy.services.UserService;

public class SwiggyDemo {

    public static void main(String args[]) throws LicenseInvalidException {

        UserRepository userRepository=new UserRepository();
        UserService userService=new UserService(userRepository);
        UserController userController=new UserController(userService);
        Driver driver=userController.createDrive("Arun","Arun@gmail.com",4);

        System.out.println(driver.getEmail());
        System.out.println(driver.getId());
    }
}
