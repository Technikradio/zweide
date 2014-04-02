package zweide.tompong;

public class GBAE{
  public static boolean running = true;
  public static void pause(){
    running = false;
  }

  public static void play() {
    running = true;
    Tompong.recreateGameThread();
  }

  public static boolean getRunningState(){
    return running;
  }
}
