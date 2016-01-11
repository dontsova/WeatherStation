package ua.com.company;

/**
 * Created by admin on 11.01.2016.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
