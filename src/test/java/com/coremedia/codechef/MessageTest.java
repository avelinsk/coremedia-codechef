package com.coremedia.codechef;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

  @Test
  public void testSimple(){
    String input = "When not studying nuclear physics, Bambi likes to play\n" +
            "beach volleyball.";
    String expected = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";

    Message result = new Message();
    result.add(input);
    assertEquals(expected, result.getElements().iterator().next());
  }

}