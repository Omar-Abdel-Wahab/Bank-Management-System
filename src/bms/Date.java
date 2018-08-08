package bms;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "" + day + "/" + month + "/" + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date)) {
            return false;
        }
        Date d = (Date) obj;
        return d.day == day && d.month == month && d.year == year;
    }

}
