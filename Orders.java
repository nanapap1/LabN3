



class Orders {
    private String[] orders = new String[0]; // поле - список заказов
    private int[] orders_et = new int[0]; // поле - список этапов готовки
    private String[] del_orders = new String[0]; // поле - список выполненных заказов
    public Orders(int max_orders) {  //конструктор, который создает списки с ограничением по максимальному кол-ву заказов в ресторане
        this.orders = new String[max_orders];
        this.orders_et = new int[max_orders];
    }
    public void AddOrder(String P, int K,int now_orders) { //добавление заказа на свободную позицию в список
        orders[now_orders] = P;
        orders_et[now_orders] = K;
    }
    public String[] getOrders() { //геттер списка заказов
        return orders;
    }
    public int[] getOrders_et() { //геттер списка этапов готовки
        return orders_et;
    }
    public String[] getDelOrders() { //геттер списка выполненных заказов
        return del_orders;
    }
    public boolean OneOrd(int numb,int end,int now) { //функция для выполнения действия, возвращая информацию, был ли удален заказ из-за полного выполнения
        if(numb - 1 - end   < 0 || numb - 1 - end  > now) { //проверка на дурака при вводе номера, невозможного для обработки
             error_limit();
             return false;
        }
        else {
            orders_et[numb - 1 - end] =  orders_et[numb - 1 - end]-1 ;//минус один этап
        if(orders_et[numb - 1 - end] == 0) { //удаление в случае достижения нуля в значении количества этапов
            DeleteAdd(orders[numb - 1 - end]); //добавление в список выполненных
            for(int i = numb - 1 - end;i < orders_et.length-1;i++) { //перенос списков
                orders_et[i] = orders_et[i+1];
                orders[i] = orders[i+1];
                
            }
            return true;
        }
        else {
            return false;
        }
        }
        
    }



   public void EndOrder(int numb) { //удаление заказа при его отмене
    for(int i = numb - 1;i < orders_et.length-1;i++) {
        orders_et[i] = orders_et[i+1];
        orders[i] = orders[i+1];
    }

   }

    private void DeleteAdd(String P) {    //функция для обновления массива выполненных заказов
       String[] del_orders1 = new String[del_orders.length+1];
       for (int i = 0; i <del_orders.length; i++) {
        del_orders1[i] = del_orders[i];
       }
       del_orders1[del_orders.length] = P;
       del_orders = del_orders1.clone(); 
    }

    private void error_limit() {    //системное сообщение для не прохода проверки на дуракак
         System.out.print("Невозможно выполнить действие, данный заказ был отменен или выполнен");
    }

    
    
}