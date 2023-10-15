package model.service;

public class Counter implements AutoCloseable {

    private static int count = 0;
    private boolean isClosed = false;

    public void add() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public void close() {
        isClosed = true;
    }
}