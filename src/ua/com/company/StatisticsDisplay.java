package ua.com.company;

/**
 * Created by admin on 11.01.2016.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    private float min = 0;
    private float max = 0;
    private float avg = 0;


    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;

        MaxMinCalc(temperature);
        AvgCalc(max, min);

        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + max + "/" + avg + "/" + min + "/");
    }

    private void AvgCalc(float Max, float Min){
        if (Max == Min) {
            this.avg = Max;
        } else {
            float i = Min;
            float j = Max;
            while (++i < --j)
                ;
            this.avg = i;
        }
    }

    private void MaxMinCalc(float temperature) {
        if(this.max == 0){
            this.max = temperature;
            this.min = temperature;
        } else {
            if(temperature > this.max){
                this.max = temperature;
            } else {
                if (temperature < min){
                    this.min = temperature;
                }
            }
        }
    }


}
