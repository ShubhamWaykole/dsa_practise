package DesignPatterns.Creational;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        System.out.println(LoanFactory.getLoan("commercial",1000000L));
        System.out.println(LoanFactory.getLoan("housing",5000000L));
        System.out.println(LoanFactory.getLoan("vehicle",600000L));
    }

    class LoanFactory {
        public static Loan getLoan(String type, Long amount) {
            if(type == "commercial")
                return new CommercialLoan(amount);
            else if(type == "vehicle")
                return new VehicleLoan(amount);
            else if(type == "housing")
                return new HousingLoan(amount);
            return null;
        }
    }


}

abstract class Loan {
    String type;
    Long amount;
    double tenure;
    double interestRate;

    public Loan(String type,Long amount, double tenure, double interestRate) {
        this.type = type;
        this.amount = amount;
        this.tenure = tenure;
        this.interestRate = interestRate;
    }

    public abstract String getLoanDetails();
}

 class CommercialLoan extends Loan {

    public CommercialLoan(Long amount) {
        super("COMMERCIAL_LOAN",amount,10.0,12.0);
    }

    @Override
    public String getLoanDetails() {
        return this.toString();
    }

    public String toString() {
        return "CommercialLoan{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", tenure=" + tenure +
                ", interestRate=" + interestRate +
                '}';
    }
}

 class HousingLoan extends Loan {

    public HousingLoan(Long amount) {
        super("COMMERCIAL_LOAN",amount,15.0,8.0);
    }

    @Override
    public String getLoanDetails() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "HousingLoan{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", tenure=" + tenure +
                ", interestRate=" + interestRate +
                '}';
    }
}

 class VehicleLoan extends Loan {

    public VehicleLoan(Long amount) {
        super("VEHICLE_LOAN",amount,4.0,10.0);
    }

    @Override
    public String getLoanDetails() {
        return this.toString();
    }

    public String toString() {
        return "VehicleLoan{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", tenure=" + tenure +
                ", interestRate=" + interestRate +
                '}';
    }
}


