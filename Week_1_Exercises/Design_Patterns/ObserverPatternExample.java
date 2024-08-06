package Week_1_Exercises.Design_Patterns;

import java.util.*;

interface Stock {
    void registerObserver(Observer observer);

    void deregisterObserver(Observer observer);

    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void setStockPrice(double price) {
        this.stockPrice = price;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

interface Observer {
    void update(double stockPrice);
}

class MobileApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("MobileApp: Stock price updated to $" + stockPrice);
    }
}

class WebApp implements Observer {
    public void update(double stockPrice) {
        System.out.println("WebApp: Stock price updated to $" + stockPrice);
    }
}

class StockMarketTest {
    public void test() {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Setting stock price...");
        // call the stockMarket.setStockPrice with parameters price to set the price

        System.out.println("\nRemoving MobileApp and updating stock price");
        stockMarket.deregisterObserver(mobileApp);
        // call the stockMarket.setStockPrice with parameters price to set the price
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarketTest test = new StockMarketTest();
        test.test();
    }
}
