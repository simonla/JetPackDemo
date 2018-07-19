package cn.zengmingyang.ado.jetpackdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends Activity {
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    @IntDef({SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface WeekDays {
    }

    @WeekDays
    int currentDay = SUNDAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurrentDay(WEDNESDAY);

        @WeekDays int today = getCurrentDay();
        switch (today) {
            case SUNDAY:
                break;
            case MONDAY:
                break;
            default:
                break;
            case FRIDAY:
                break;
            case SATURDAY:
                break;
            case THURSDAY:
                break;
            case TUESDAY:
                break;
            case WEDNESDAY:
                break;
        }
    }

    /**
     * 参数只能传入在声明范围内的整型，不然编译通不过
     *
     * @param currentDay
     */
    public void setCurrentDay(@WeekDays int currentDay) {
        this.currentDay = currentDay;
    }

    @WeekDays
    public int getCurrentDay() {
        return currentDay;
    }
}
