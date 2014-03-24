package zweide.tompong;
public static class Recources{
  
  public static final Level[] = LoadLevels();
  
  public static Level[] LoadLevels(){
    Level[2] levels; //easy medium hard
    { //Level easy
      Level l;
      l.name = "easy";
      l.minUpSpeedPlayer = 10;
      l.maxUpSpeedPlayer = 30;
      l.minUpSpeedBoss = 9;
      l.maxUpSpeedBoss = 25;
      l.minDownSpeedPlayer = 10;
      l.maxDownSpeedPlayer = 30;
      l.minDownSpeedBoss = 9;
      l.maxDownSpeedBoss = 25;
      l.ballSpeed = 5;
      Levels[0] = l;
    }
    { //Level easy
      Level l;
      l.name = "medium";
      l.minUpSpeedPlayer = 8;
      l.maxUpSpeedPlayer = 30;
      l.minUpSpeedBoss = 8;
      l.maxUpSpeedBoss = 30;
      l.minDownSpeedPlayer = 8;
      l.maxDownSpeedPlayer = 30;
      l.minDownSpeedBoss = 8;
      l.maxDownSpeedBoss = 30;
      l.ballSpeed = 10;
      Levels[1] = l;
    }
    { //Level easy
      Level l;
      l.name = "hard";
      l.minUpSpeedPlayer = 8;
      l.maxUpSpeedPlayer = 25;
      l.minUpSpeedBoss = 10;
      l.maxUpSpeedBoss = 30;
      l.minDownSpeedPlayer = 8;
      l.maxDownSpeedPlayer = 25;
      l.minDownSpeedBoss = 10;
      l.maxDownSpeedBoss = 30;
      l.ballSpeed = 15;
      Levels[2] = l;
    }
    return levels;
  }
}