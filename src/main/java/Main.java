
import java.lang.reflect.Method;
import peronne.Enfant;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ituClass<?> clazz = Class.forName("X");
      X x = (X) clazz.newInstance();
      Class[] argTypes = { String.class };
      Method method = clazz.getMethod("sorato", argTypes);
      Object[] data = { "Hello" };
      method.invoke(x, data);
 */
public class Main {
  public static void main(String[] args) {
    try {
      Class<?> clazz = Class.forName("X");
      X x = (X) clazz.newInstance();
      Class[] argTypes = { String.class };
      Method method = clazz.getMethod("sorato", argTypes);
      Object[] data = { "Hello", "hej" };
      method.invoke(x, data); // Output: Instance method: Hello
 
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}