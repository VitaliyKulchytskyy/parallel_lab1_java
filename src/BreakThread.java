public class BreakThread implements Runnable {
    private volatile boolean stopPermission = false;
    private final int execTime;

   public BreakThread(int execTime) {
       this.execTime = execTime;
   }

    @Override
    public void run() {
        try {
           Thread.sleep(this.execTime * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopPermission = true;
    }

    synchronized public boolean isStopPermission() {
       return this.stopPermission;
    }
}