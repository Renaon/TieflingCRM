package com.crm.Tiefling.DTO;

import com.crm.Tiefling.entity.Room;
import com.crm.Tiefling.entity.User;
import com.crm.Tiefling.observer.BookObservable;
import com.crm.Tiefling.observer.Observer;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class BookingDTO  implements BookObservable {
    private List<Observer> observers;
    private Date date;
    private User user;
    private Room room;
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void updateNotify(int year, int month, int day, int hour, int minute) {
        Date date = new Date(year, month, day);
        date.setTime(hour + minute);
        for (Object o: observers.toArray()) {
            ((Observer)o).update(this.getDate(), date);
        }
    }
}
