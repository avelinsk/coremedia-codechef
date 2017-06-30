package test.java.common.lowest.anchestor;

import main.java.common.lowest.anchestor.CoreWave;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by emueller on 30.06.17.
 */
public class CoreWaveTest {

  private CoreWave coreWave = new CoreWave();

  @Test
  public void findClosestCommonManager() {
    assertEquals(coreWave.ulrike, coreWave.findClosestCommonManager(coreWave.milton, coreWave.nina));
    assertEquals(coreWave.kevin, coreWave.findClosestCommonManager(coreWave.nina, coreWave.jan));
    assertEquals(coreWave.simon, coreWave.findClosestCommonManager(coreWave.nina, coreWave.frank));
    assertEquals(coreWave.ulrike, coreWave.findClosestCommonManager(coreWave.nina, coreWave.ulrike));

    assertNotEquals(coreWave.milton, coreWave.findClosestCommonManager(coreWave.kevin, coreWave.francine));
    assertNotEquals(coreWave.andy, coreWave.findClosestCommonManager(coreWave.ulrike, coreWave.frank));
  }

}