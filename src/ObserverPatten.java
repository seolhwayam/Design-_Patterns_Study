import java.util.ArrayList;
import java.util.List;

interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
interface Observer{
    public void update(float temp, float humidity, float pressure);
}
interface DisplayElement{
    public void display();
}

class WeatherData implements Subject{
    private List<Observer> observers;
    private float temerature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer obsever: observers)
            obsever.update(temerature,humidity,pressure);
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temerature, float humidity, float pressure){
        this.temerature = temerature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
class CurrentConditionDispaly implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public CurrentConditionDispaly(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("현재 상태: 온도 " + temperature + "F, 습도 "+ humidity+"%");
    }
}


public class ObserverPatten {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDispaly currentConditionDispaly = new CurrentConditionDispaly(weatherData);


        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,72,20.4f);
    }
}
