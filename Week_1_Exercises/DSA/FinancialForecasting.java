package Week_1_Exercises.DSA;

public class FinancialForecasting {
    double[] pastValues;
    int numberOfForecasts;

    FinancialForecasting() {
        pastValues = new double[1000];
        numberOfForecasts = 1;
    }

    FinancialForecasting(double[] pastvalues, int numberOfForecasts) {
        this.pastValues = pastValues;
        this.numberOfForecasts = numberOfForecasts;
    }

    public static void main(String[] args) {

        double[] forecastedValues = forecastFuture(pastValues, numberOfForecasts);

        System.out.println("Forecasted Values:");
        for (double value : forecastedValues) {
            System.out.println(value);
        }
    }

    public static double[] forecastFuture(double[] pastValues, int numberOfForecasts) {
        if (numberOfForecasts == 0) {
            return pastValues;
        }
        double average = calculateAverage(pastValues, pastValues.length);

        double[] newValues = new double[pastValues.length + 1];

        System.arraycopy(pastValues, 0, newValues, 0, pastValues.length);

        newValues[pastValues.length] = average;

        return forecastFuture(newValues, numberOfForecasts - 1);
    }

    private static double calculateAverage(double[] values, int length) {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += values[i];
        }
        return sum / length;
    }
}
