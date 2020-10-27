package com.cg.census;

import com.opencsv.bean.CsvBindByName;


public class StateCensus {

    @CsvBindByName(column = "State")
    private String stateName;

    @CsvBindByName(column = "Population",required = true)
    private double population;

    @CsvBindByName(column = "AreaInSqKm")
    private double areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private double densityPerSqKm;

    public StateCensus() {

    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(double areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public double getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(double densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return  "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\''
                +"\n";
    }
}

