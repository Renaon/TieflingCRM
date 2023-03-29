package com.crm.Tiefling.observer;

public interface BookObservable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void updateNotify(int year, int month, int day, int hour, int minute);
}
