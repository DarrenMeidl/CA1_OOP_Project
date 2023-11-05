public class Activity implements Comparable<Activity>{
    //Fields - Darren
    private String type;
    private double duration;
    private String date;
    private double distance;
    private double avgHeartRate;

    private double intensity;
    private String intensityType;
    private double caloriesBurned;

    //Full Constructor - Darren
    public Activity(String type, double duration, String date, double distance, double avgHeartRate, double intensity, String intensityType, double caloriesBurned) {
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
    public Activity(String type, double duration, String date, double distance, double avgHeartRate) {
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
        this.date = "00/00/00";
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
    public String getDate() {
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
    public void setDate(String date) {
        this.date = date;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setAvgHeartRate(double avgHeartRate) {
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


    //Calculates energy expended - Darren
    public void calculateEnergyExpended(){

    }
    //Calculates calories burned by multiplying intensity by duration - Darren
    public void calculateCaloriesBurned(double intensity, double duration){
        this.caloriesBurned = intensity * duration;
    }
    //Calculates the Intensity type - Darren
    public void calculateIntensityType(double intensity, String type){
        String msg = "NO IFs WERE CALLED";
        //If the activity type is "Swimming" go through these checks - Darren
        if (type == "Swimming"){
            //If intensity is X, set msg String to X - Darren
            if (intensity == 0.5){
                msg = "Very Light";
            }
            else if (intensity == 1.25){
                msg = "Light";
            }
            else if (intensity == 2){
                msg = "Moderate";
            }
            else if (intensity == 2.75){
                msg = "Vigorous";
            }
            else if (intensity == 3.5){
                msg = "Very Vigorous";
            }
        }
        //If the activity type is "Running" go through these checks - Darren
        if (type == "Running"){
            //If intensity is X, set msg String to X - Darren
            if (intensity == 0.5){
                msg = "Very Light";
            }
            else if (intensity == 0){
                msg = "Light";
            }
            else if (intensity == 0){
                msg = "Moderate";
            }
            else if (intensity == 0){
                msg = "Vigorous";
            }
            else if (intensity == 0){
                msg = "Very Vigorous";
            }
        }
        //If the activity type is "Cycling" go through these checks - Darren
        if (type == "Cycling"){
            //If intensity is X, set msg String to X - Darren
            if (intensity < 8){
                msg = "Very Light";
            }
            else if (intensity == 8){
                msg = "Light";
            }
            else if (intensity == 0){
                msg = "Moderate";
            }
            else if (intensity == 0){
                msg = "Vigorous";
            }
            else if (intensity == 0){
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