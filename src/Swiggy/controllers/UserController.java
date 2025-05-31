package Swiggy.controllers;

import Swiggy.exceptions.LicenseInvalidException;
import Swiggy.models.Driver;
import Swiggy.services.UserService;

public class UserController {

    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    public Driver createDrive(String name,String email,long licenseId) throws LicenseInvalidException {
     return userService.createDriver(name, email, licenseId);
    }
}
