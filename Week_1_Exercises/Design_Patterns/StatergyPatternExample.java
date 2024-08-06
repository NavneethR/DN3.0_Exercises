package Week_1_Exercises.Design_Patterns;

interface PaymentStatergy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStatergy {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
    }

    public void pay(double amount) {
        System.out.println("Executing payment of $" + amount + "with card.");
    }
}

class PayPalPayment implements PaymentStatergy {
    String email;
    String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Executing payment of $" + amount + " with email.");
    }
}

class PaymentContext {
    PaymentStatergy paymentStatergy;

    public void setPaymentStatergy(PaymentStatergy paymentStatergy) {
        this.paymentStatergy = paymentStatergy;
    }

    public void executePayment(double amount) {
        paymentStatergy.pay(amount);
    }
}

class PaymentSystemTest {
    public void test() {
        PaymentContext paymentContext = new PaymentContext();
        PaymentStatergy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe", "12/25");
        paymentContext.setPaymentStatergy(creditCardPayment);
        System.out.println("Using Credit Card Payment:");
        paymentContext.executePayment(150.00);

        System.out.println();

        PaymentStatergy payPalPayment = new PayPalPayment("john.doe@example.com", "securePassword");
        paymentContext.setPaymentStatergy(payPalPayment);
        System.out.println("Using PayPal Payment:");
        paymentContext.executePayment(250.00);
    }
}

public class StatergyPatternExample {
    public static void main(String[] args) {
        PaymentSystemTest test = new PaymentSystemTest();
        test.test();
    }
}
