package com.cg.census;

public class CensusAnalyserException extends Exception {

    public ExceptionType type;

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, RUN_TIME_EXCEPTION
    }

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
