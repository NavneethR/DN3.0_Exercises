package Week_1_Exercises.Design_Patterns;

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is switched ON.");
    }

    public void turnOff() {
        System.out.println("The light is switched OFF.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

class HomeAutomationTest {
    public void test() {
        Light livingRoomLight = new Light();

        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();
    }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        HomeAutomationTest test = new HomeAutomationTest();
        test.test();
    }
}
