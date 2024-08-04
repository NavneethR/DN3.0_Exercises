package Week_1_Exercises.Design_Patterns;

import java.util.*;

interface Notifier {
    void send(String message);
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending email...");
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification with message: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack notification with message: " + message);
    }
}

class NotificationSystemTest {
    void test() {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSMSEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        System.out.println("Sending notifications through Email only:");
        emailNotifier.send("Enter your message here!");

        System.out.println("\nSending notifications through Email and SMS:");
        smsEmailNotifier.send("Enter your 2nd message here!");

        System.out.println("\nSending notifications via Email, SMS, and Slack:");
        slackSMSEmailNotifier.send("Enter your 3rd message here!");
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        NotificationSystemTest nst = new NotificationSystemTest();
        nst.test();
    }
}
