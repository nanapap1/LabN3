
import Orders;
class Restaraunt
  {
    
      private int max_orders = 0; //поле для ограничений максимального кол-ва заказов ресторана
      private int cnt_orders = 0; //общее количество заказов, которое когда-нибудь давали ресторану
      private int now_orders = 0; //количество заказов, которые прямо сейчас находятся в обработке
      private int end_orders = 0; //количество заказов, которые были отменены или выполнены
      private Orders list; // объект класса Заказ
      public Restaraunt(int max_orders) { //конструктор Ресторана
        if (max_orders > 0) {     // проверка на дурака для кол-ва заказов
          this.max_orders = max_orders;
          this.list = new Orders(max_orders);
        }
        else {
          error_amount();  // не проход проверки
          this.max_orders = max_orders;
          this.list = new Orders(0);
        }  
      }
      public Restaraunt() { //запасной конструктор для дураков
        this.max_orders = 0;
        awarenumbr();
        this.list = new Orders(0);
      }
      public void NewOrder(String P, int K) { //новый заказ с названием блюда и количеством этапов готовки
        if(now_orders < max_orders) { //проверка на максимум заказов в ресторане
          cnt_orders++; //доавление в общее и нынешнее количество
          now_orders++;
          this.list.AddOrder(P,K, now_orders-1); //добавление заказа
        }
        else  {
          limit(); //ошибка о невозможности принять заказ из-за максимальной загруженности
        }
      }

     public void ListOrders() { //вывод на экран действующих заказов
         String[] orders1 = list.getOrders();   //геттер заказов
         int[] orders1_et = list.getOrders_et(); //геттер этапов готовки
         for( int i = 0; i < now_orders; i++) {
          System.out.println("Заказ: " + orders1[i] + " | Этапов готовки: " + orders1_et[i]); //просто выводим
         }
     }
     public void OneOrder(int numb) {      //одно действие по заказу
          if(list.OneOrd(numb,end_orders,now_orders)){ //выполняем дейсивие и проверяем, нужно ли что-то удалять. если да - изменяем количество; 
            end_orders++;
            now_orders--;
          }
     }
     public void ManyOrder(int numb,int n){ //несколько действий по одному заказу 
      for(int j = 1;j <= n; j++) {
        if(list.OneOrd(numb,end_orders,now_orders)){ //выполняем дейсивие и проверяем, нужно ли что-то удалять. если да - изменяем количество; 
          end_orders++;
          now_orders--;
          break; // если заказ уже выполнен, повторять действия не надо
        }
      }
     }

     public void ManyOrders(int n){ // много действий по разным заказам
      int numb = 1+ end_orders;
      for(int j = 1;j <= n; j++) {
        if(list.OneOrd(numb,end_orders,now_orders)){ //выполняем дейсивие и проверяем, нужно ли что-то удалять. если да - изменяем количество; 
          end_orders++;
          now_orders--;
          numb++;
        }
      }
     }

     public void ManyOrdersList(int[] n){ //по одному действию на массив номеров
      int numb = 0;
      for(int j = 0;j < n.length; j++) {
        if(list.OneOrd(n[j],end_orders,now_orders)){ //выполняем действие и проверяем, нужно ли что-то удалять. если да - изменяем количество; 
          end_orders++;
          now_orders--;
        }
      }
     }

     public void ListEndOrders() { //перечислить все заказы, которые завершились
      String[] del_orders1 = list.getDelOrders(); //геттер такого списка
      for( int i = 0; i < del_orders1.length; i++) {
        System.out.println("Заказ: " + del_orders1[i] ); //вывод
       }

     }

     public void CancelOrder(int numb) { //отмена заказа по номеру среди нынешних
              list.EndOrder(numb); //функция
              end_orders++; 
              now_orders--; //изменяем параметры
     }
      
      private void awarenumbr() { //для проверки на дурака
        System.out.println("Введите максимальное количество заказов в вашем ресторана, используя функцию UpdateMaxOrders() или заново инициализируйте ресторан");
      }
      private void limit() { //макс. кол-во заказов
        System.out.println("В настоящий момент в ресторане обрабатывается максимальное количество заказ. Подождите, пожалуйста, когда один из них будет выполнен");
      }
      private void error_amount() { //для проверки на дурака
        System.out.println("Вы ввели некорректное максимальное количество заказов в вашем ресторана, заново инициализируйте ресторан");
      }
  
  }
