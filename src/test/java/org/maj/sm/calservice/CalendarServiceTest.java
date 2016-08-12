package org.maj.sm.calservice;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shamik.majumdar
 */
public class CalendarServiceTest {
    private MyCalendarDate calendarDate = new MyCalendarDate(LocalDate.now());
    @BeforeTest
    public void setup(){
        ConfRoom flex_a = new ConfRoom("flexa",2);
        ConfRoom flex_b = new ConfRoom("flexb",5);
        ConfRoom flex_c = new ConfRoom("flexc",6);
        ConfRoom flex_d = new ConfRoom("flexd",20);
        ConfRoom flex_e = new ConfRoom("flexe",25);
        calendarDate.addConfRoom(flex_a);
        calendarDate.addConfRoom(flex_b);
        calendarDate.addConfRoom(flex_c);
        calendarDate.addConfRoom(flex_d);
        calendarDate.addConfRoom(flex_e);
        calendarDate.addReservation(new Reservation(flex_a, LocalDateTime.now().minusHours(5),LocalDateTime.now().minusHours(4)));
        calendarDate.addReservation(new Reservation(flex_a, LocalDateTime.now().minusHours(3),LocalDateTime.now().minusHours(2)));
        calendarDate.addReservation(new Reservation(flex_b, LocalDateTime.now().minusHours(2),LocalDateTime.now().minusHours(1)));
        calendarDate.addReservation(new Reservation(flex_c, LocalDateTime.now().minusHours(2),LocalDateTime.now().minusHours(1)));
        calendarDate.addReservation(new Reservation(flex_d, LocalDateTime.now().minusHours(2),LocalDateTime.now().minusHours(1)));

    }
    @Test
    public void testRooms(){
        List<ConfRoom> rooms =  calendarDate.getAvailableRooms(10,LocalDateTime.now().minusHours(2),LocalDateTime.now().minusHours(1));
        Assert.assertEquals(rooms.size(),1);
        Assert.assertEquals(rooms.get(0).getName(),"flexe");
    }
}
