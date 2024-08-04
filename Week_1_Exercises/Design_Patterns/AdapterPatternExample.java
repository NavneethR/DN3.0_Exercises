package Week_1_Exercises.Design_Patterns;

import java.util.*;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment...");
    }
}

class GPayPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing Gpay transaction...");
    }
}

class PayPalAdapter implements PaymentProcessor {
    PayPalPaymentGateway payPalPaymentGateway;

    public PayPalAdapter(PayPalPaymentGateway payPalPaymentGateway) {
        this.payPalPaymentGateway = payPalPaymentGateway;
    }

    public void processPayment(double amount) {
        payPalPaymentGateway.makePayment(amount);
    }
}

class GpayAdapter implements PaymentProcessor {
    private GPayPaymentGateway GPayPaymentGateway;

    public GpayAdapter(GPayPaymentGateway GPayPaymentGateway) {
        this.GPayPaymentGateway = GPayPaymentGateway;
    }

    public void processPayment(double amount) {
        GPayPaymentGateway.makePayment(amount);
    }
}

class PaymentSystemTest {
    void test() {

        PayPalPaymentGateway payPalPaymentGateway = new PayPalPaymentGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalPaymentGateway);
        // pass the amount of money to pay in the processPayment method of
        // payPalProcessor

        GPayPaymentGateway stripePaymentGateway = new GPayPaymentGateway();
        PaymentProcessor GpayProcessor = new StripeAdapter(stripePaymentGateway);
        // pass the amount of money to pay in the processPayment method of GpayProcessor
    }
}

class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentSystemTest paytest = new PaymentSystemTest();
        paytest.test();
    }
}
