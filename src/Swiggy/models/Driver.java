package Swiggy.models;

import Swiggy.exceptions.LicenseInvalidException;

public class Driver extends BaseEntity{

    private String name;
    private String email;
    private long licenseId;
    private Driver(String name,String email,long licenseId)
    {
        this.name=name;
        this.email=email;
        this.licenseId=licenseId;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public long getLicenseId() { return licenseId; }
    public int getId() { return id; }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private String name;
        private String email;
        private long licenseId;

        public Builder setName(String name)
        {
            this.name=name;
            return this;
        }
        public Builder setEmail(String email)
        {
            this.email=email;
            return this;
        }
        public Builder setLicenseId(long licenseId)
        {
            this.licenseId=licenseId;
            return this;
        }

        public Driver build() throws LicenseInvalidException {
            if(this.licenseId < 5)
            {
                throw new LicenseInvalidException("License not valid , Please verify it Once");
            }
            Driver driver=new Driver(this.name,this.email,this.licenseId);
            return driver;
        }
    }
}
