package factoryMethod.everydayExample;

import java.util.Calendar;

public class CalenderExample {
    public void calender(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
