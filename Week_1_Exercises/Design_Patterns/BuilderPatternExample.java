package Week_1_Exercises.Design_Patterns;

import java.util.*;

class Computer {
    String CPU;
    String RAM;
    String storage;
    String GPU;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .build();

        System.out.println("Gaming PC Configuration: ");
        System.out.println(gamingPC);

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated Graphics")
                .build();

        System.out.println("\nOffice PC Configuration: ");
        System.out.println(officePC);
    }
}
