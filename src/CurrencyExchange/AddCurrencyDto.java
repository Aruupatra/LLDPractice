package CurrencyExchange;

public class AddCurrencyDto {

     Currency from;
     Currency to;
     double rate;
     double amount;

    // ✅ Private constructor
    private AddCurrencyDto(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.rate = builder.rate;
        this.amount = builder.amount;
    }

    // ✅ Getters
    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    // ✅ Static Builder class
    public static class Builder {
        private Currency from;
        private Currency to;
        private double rate;
        private double amount;

        public Builder from(Currency from) {
            this.from = from;
            return this;
        }

        public Builder to(Currency to) {
            this.to = to;
            return this;
        }

        public Builder rate(double rate) {
            this.rate = rate;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public AddCurrencyDto build() {
            return new AddCurrencyDto(this);
        }
    }

    // ✅ Optional: static method to start building
    public static Builder builder() {
        return new Builder();
    }
}
