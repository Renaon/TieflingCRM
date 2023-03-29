package com.crm.Tiefling.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public class ChangeDate implements Observer{
    Logger logger = LoggerFactory.getLogger(ChangeDate.class);
    private BookObservable bookObservable;
    public ChangeDate(BookObservable bookObservable){
        this.bookObservable = bookObservable;
        bookObservable.addObserver(this);
    }

    @Override
    public void update(Date olddate, Date newdate) {
        if (olddate.before(newdate)){
            logger.info("Игра перенеслась. Проверьте расписание");
        }
    }
}
