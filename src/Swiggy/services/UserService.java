package Swiggy.services;

import Swiggy.exceptions.LicenseInvalidException;
import Swiggy.models.Driver;
import Swiggy.repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public Driver createDriver(String name,String email,long licenseId) throws LicenseInvalidException {
        Driver driver=Driver.getBuilder().setName(name).setEmail(email).setLicenseId(licenseId).build();
        Driver driver1=userRepository.saveDriver(driver);
        return  driver1;
    }
}
