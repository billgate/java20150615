package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context02.xml");
    
    Car car1 = (Car)ctx.getBean("car1");
    
    Car car2 = (Car)ctx.getBean("car2");
    Car car3 = (Car)ctx.getBean("car3");
    if (car2 == car3) System.out.println("car2 == car3");
    
    Car car4 = (Car)ctx.getBean("car4");
    Car car5 = (Car)ctx.getBean("car5");
    Car car6 = (Car)ctx.getBean("car6");
    if (car4 == car5) System.out.println("car4 == car5");
    if (car4 == car6) System.out.println("car4 == car6");
  }
  
  /*
  public static void main(String[] args) {
    Car c = new Car();
    c.setModel("티코");
    c.setCapacity(5);
    c.setOutDate(Date.valueOf("2015-06-19"));
    
    System.out.println(c);

  }*/

}
