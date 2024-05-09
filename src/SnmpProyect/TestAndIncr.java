package SnmpProyect;

public class TestAndIncr {
    private int value = 0;

    // Método synchronized para incrementar el valor de manera atómica
    public synchronized void increment() {
        value++;
    }

    // Método synchronized para obtener el valor actual
    public synchronized int getValue() {
        return value;
    }
}
