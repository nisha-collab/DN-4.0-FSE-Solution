package Week1.Algorithm_Data_Structures.FinancialForecasting.code;

public class FinancialForecast {

    public static double forecast(double value, double rate, int years) {
        if (years == 0) return value;
        return forecast(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.10; 
        int years = 5;

        double result = forecast(currentValue, growthRate, years);

        System.out.printf("Future value after %d years: Rs. %.2f\n", years, result);

    }
}
