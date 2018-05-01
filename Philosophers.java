class Philosophers {

  public static void main(String[] args) throws Exception {
    final phil[] phils = new phil[5];
    Object[] forks = new Object[phils.length];

    for (int i = 0; i < forks.length; i++) {
      forks[i] = new Object();
    }


    for (int i = 0; i < phils.length; i++) {
      Object leftFork = forks[i];
      Object rightFork = forks[(i + 1 ) % forks.length];

      if (i == phils.length - 1) {
        // the last phil picks up the right fork first
        phils[i] = new phil(rightFork, leftFork);
      } else {
        phils[i] = new phil(leftFork, rightFork);
      }

      Thread t = new Thread(phils[i], "Philosopher " + (i + 1));
      t.start();
    }
  }

}
