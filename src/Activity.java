import java.time.LocalDate;

public class Activity implements Comparable<Activity>{
    //Fields - Darren
    private String type;
    private double duration;
    private LocalDate date;
    private double distance;
    private int avgHeartRate;

    private double intensity;
    private String intensityType;
    private double caloriesBurned;

    //Full Constructor - Darren
    public Activity(String type, double duration, LocalDate date, double distance, int avgHeartRate, double intensity, String intensityType, double caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
        this.intensity = intensity;
        this.intensityType = intensityType;
        this.caloriesBurned = caloriesBurned;
    }
    //Semi-Full Constructor - Darren
    public Activity(String type, double duration, LocalDate date, double distance, int avgHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.avgHeartRate = avgHeartRate;
    }
    //Default Constructor - Darren
    public Activity() {
        this.type = "type";
        this.duration = 0;
        this.date = LocalDate.parse("0000-01-01");
        this.distance = 0;
        this.avgHeartRate = 0;
    }

    //Getters - Darren
    public String getType() {
        return type;
    }
    public double getDuration() {
        return duration;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getDistance() {
        return distance;
    }
    public double getAvgHeartRate() {
        return avgHeartRate;
    }
    public double getIntensity() {
        return intensity;
    }
    public String getIntensityType(){
        return intensityType;
    }
    public double getCaloriesBurned() {
        return caloriesBurned;
    }


    //Setters - Darren
    public void setType(String type) {
        this.type = type;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setAvgHeartRate(int avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }
    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }
    public void setIntensityType(String intensityType){
        this.intensityType = intensityType;
    }
    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }


    //Calculates energy expended by calculating KM per hour - Tomas
    public void calculateEnergyExpended(double distance, double duration){
        this.intensity = distance/(duration/60);
    }
    //Calculates calories burned by multiplying intensity by duration - Darren
    public void calculateCaloriesBurned(double intensity, double duration){
        this.caloriesBurned = intensity * duration;
    }
    //Calculates the Intensity type - Darren
    public void calculateIntensityType(){
        String msg = "NO IFs WERE CALLED";
        //If the activity type is "Swimming" go through these checks - Darren
        if (this.type == "Swimming"){
            //If intensity is X, set msg String to X - Darren
            if (this.intensity == 0.5){
                msg = "Very Light";
            }
            else if (this.intensity == 1.25){
                msg = "Light";
            }
            else if (this.intensity == 2){
                msg = "Moderate";
            }
            else if (this.intensity == 2.75){
                msg = "Vigorous";
            }
            else if (this.intensity == 3.5){
                msg = "Very Vigorous";
            }
        }
        //If the activity type is "Running" go through these checks - Darren
        if (this.type == "Running"){
            //If intensity is lower than X, set the msg to X - Tomas
            if (this.intensity < 4){
                msg = "Very Light";
            }
            else if (this.intensity >=4 && this.intensity < 8){
                msg = "Light";
            }
            else if (this.intensity >= 8 && this.intensity < 12){
                msg = "Moderate";
            }
            else if (this.intensity >= 12 && this.intensity < 16){
                msg = "Vigorous";
            }
            else if (this.intensity >= 16 && this.intensity <= 24){
                msg = "Very Vigorous";
            }
        }
        //If the activity type is "Cycling" go through these checks - Darren
        if (this.type == "Cycling"){
            //If intensity is lower than X, set the msg to X - Tomas
            if (this.intensity < 8){
                msg = "Very Light";
            }
            else if (this.intensity >= 8 && this.intensity <= 16){
                msg = "Light";
            }
            else if (this.intensity >= 17 && this.intensity < 25){
                msg = "Moderate";
            }
            else if (this.intensity >= 25 && this.intensity < 33){
                msg = "Vigorous";
            }
            else if (this.intensity >= 33 && this.intensity <= 40){
                msg = "Very Vigorous";
            }
        }
        this.intensityType = msg;
    }

    @Override
    public String toString() {
        return "ACTIVITY{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                ", distance=" + distance +
                ", avgHeartRate=" + avgHeartRate +
                ", intensity=" + intensity +
                ", intensityType='" + intensityType + '\'' +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }

    @Override
    public int compareTo(Activity other){
        return this.type.compareTo(other.type);
    }
}