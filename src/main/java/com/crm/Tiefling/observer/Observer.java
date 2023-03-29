package com.crm.Tiefling.observer;

import com.crm.Tiefling.entity.Booking;
import com.crm.Tiefling.entity.Room;
import com.crm.Tiefling.entity.User;

import java.sql.Date;

public interface Observer {
    void update(Date olddate, Date newdate);
}
