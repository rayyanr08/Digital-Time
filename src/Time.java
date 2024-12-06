import java.text.DecimalFormat;

public class Time {
private int hour;
private int minute;
private int second;

public Time(int hour, int minute, int second){
    this.hour = hour;
    this.minute = minute;
    this.second = second;
}


public void tick(){
    if ((second + 1) == 60){
        second = 0;
        minute ++;
        if (minute == 60){
            minute = 0;
            hour ++;
            if (hour == 24){
                hour = 0;
                minute = 0;
                second = 0;
            }
        }
    }
    else{
        second++;
    }
}

public void add(Time addedTime){
    second += addedTime.second;
    carryOver();
    minute+= addedTime.minute;
    carryOver();
    hour += addedTime.hour;
    carryOver();
    formatTime();
}

public void carryOver() {
    if (second == 60) {
        second = 0;
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
            if (hour == 24) {
                hour = 0;
                minute = 0;
                second = 0;
            }
        }
    }
}

    public String formatTime(){
        DecimalFormat hourFormat = new DecimalFormat("00");
        DecimalFormat minuteFormat = new DecimalFormat("00");
        DecimalFormat secondFormat = new DecimalFormat("00");


        return (hourFormat.format(hour) + ":" + minuteFormat.format(minute) + ":" + secondFormat.format(second));

    }

    public String toString(){
    return formatTime();
    }

}


