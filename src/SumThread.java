public class SumThread extends Thread {
    private final int id;
    private final int step;
    private final BreakThread breakThread;

    public SumThread(int id, int step, BreakThread breakThread) {
        this.id = id;
        this.step = step;
        this.breakThread = breakThread;
    }

    @Override
    public void run() {
        long sum = 0;
        do {
            sum += this.step;
        } while (!this.breakThread.isStopPermission());
        System.out.println("ID: " + this.id + " | Sum: " + sum);
    }
}
