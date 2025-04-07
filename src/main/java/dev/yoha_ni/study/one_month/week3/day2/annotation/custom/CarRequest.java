package dev.yoha_ni.study.one_month.week3.day2.annotation.custom;

public class  CarRequest {
    private final String model;
    @YearRange(min = 2000, max = 2025)
    private final Integer year;

    public CarRequest(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "CarRequest{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
