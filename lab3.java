import java.io.PrintStream;
import java.util.Scanner;
import Restaraunt;
import Orders;
 
  
  public class lab3 {
      public static Scanner in = new Scanner(System.in);
      public static PrintStream out = System.out;
      public static void main(String[] args) {
         Restaraunt restik = new Restaraunt(5);
         restik.NewOrder("Макароны",2);
         restik.NewOrder("Греча",4);
         restik.NewOrder("Рис",3);
         restik.NewOrder("Картошка",4);
         restik.NewOrder("Арбуз",5);
         restik.NewOrder("Дыня",4);  //вылезает ошибка, ибо мы пытаемся добавить 6 заказ
         restik.ListOrders();            //список всех заказов
         out.println();

         restik.ManyOrder(3, 3);  //закрываем 3 заказ выполнением всех трех действий
         restik.ListEndOrders();         //проверяем список выполненных
         out.println();
         restik.ListOrders();            //проверяем общий список нынешних
         out.println();


         restik.OneOrder(4);       //проверяем, работает ли нумерация
         restik.ListOrders();           //проверяем общий список нынешних
         out.println();

         restik.CancelOrder(3);     //проверяем, работает ли отмена заказа
         restik.ListOrders();            //проверяем общий список нынешних
         out.println();

         restik.NewOrder("Дыня",4);  //смотрим, добавится ли заказ в конец
         restik.ListOrders();            //список всех заказов
         out.println();

         restik.ManyOrders(7);     //проверяем, работает ли массовое применение по очереди
         restik.ListOrders();            //проверяем общий список нынешних
         out.println();
         restik.ListEndOrders();         //проверяем список выполненных
         out.println();


         restik.NewOrder("Кускус",4);
         restik.ManyOrder(7, 3);  //обрабатываем последний заказ
         restik.ListOrders();            //проверяем общий список нынешних
         out.println();
          
         int[] a = new int[2];
         a[0] = 6;
         a[1] = 7;
         restik.ManyOrdersList(a);       //проверяем одно действие по массиву
         restik.ListOrders();            //проверяем общий список нынешних
         out.println();

         restik.OneOrder(3);  //вывод ошибки


         

         
         
         
         
         
         
            
        }
    
    }