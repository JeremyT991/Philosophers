public class phil implements Runnable {
  private Object leftFork;
  private Object rightFork;

  public phil(Object leftFork, Object rightFork) {
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }

  @Override
  public void run() {
    int eat = 0;
    try {
      while (eat < 3) {
         //thinking
         doAction(": Thinking");
         synchronized (leftFork) {
           doAction(": Picked up left fork");
           synchronized (rightFork) {
             // eatihng
             doAction(": Picked up right fork - eating");
             doAction(": Put down right fork");
             eat++;
           }
           // thinking
           doAction(": Put down left fork. Back to thinking.");
         }
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return;
    }
    
    try {
      doAction(": FINISHED EATING");
    } catch (InterruptedException e) {
      return;
    }
  }

  private void doAction(String action) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " " + action);
    Thread.sleep(((int) (Math.random() * 100)));
  }
}
