package zweide.tompong;

public static class GBAE{
  public static boolean running = true;
  public static void pause(){
    running = false;
  }

  public static void continue() {
    running = true;
    Resources.gameThread = new Thread(this);
    Resources.gameThread.start();
  }

  public static boolean getRunningState(){
    return running;
  }
}
