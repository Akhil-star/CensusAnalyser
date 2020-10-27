package com.cg.census;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {

    private static final String STATE_CENSUS_CSV_FILE_PATH = "StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "F:\\StateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "StateCensusData.pdf";
    private static final String STATE_CENSUS_CSV_FILE_PATH_WITH_WRONG_HEADER = "StateCensusDataWrongHeader.csv";
    private static final String STATE_CENSUS_CSV_FILE_PATH_WITH_WRONG_DELIMETER = "StateCensusDataWrongDelimiter.csv";
    private static final String STATE_CODE_CSV_FILE_PATH = "StateCode.csv";
    private static final String STATE_CODE_CSV_FILE_PATH_WITH_WRONG_HEADER = "StateCodeWrongHeader.csv";
    private static final String STATE_CODE_CSV_FILE_PATH_WITH_WRONG_DELIMETRE = "StateCodeWrongDelimiter.csv";

    @Test
    public void givenStateCensusCSVFileShouldReturnNumberOfCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadCensusData(STATE_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenStateCensusDataWithWrongFileShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);        }
    }

    @Test
    public void givenStateCensusDataWithWrongFileTypeShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaCensusDataWithIncorrectDelimiterShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(STATE_CENSUS_CSV_FILE_PATH_WITH_WRONG_DELIMETER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }

    @Test
    public void givenStateCensusDataWithWrongHeaderShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadCensusData(STATE_CENSUS_CSV_FILE_PATH_WITH_WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
           Assert.assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }

    //testcases for statecode
    @Test
    public void givenIndianStateCodeFile_ShouldReturn_CorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadStateCode(STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenStateCode_WithWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadStateCode(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenStateCodeFile_WithWrongFileType_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadStateCode(WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenStateCodeCSVFile_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadStateCode(STATE_CODE_CSV_FILE_PATH_WITH_WRONG_DELIMETRE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }

    @Test
    public void givenStateCodeCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadStateCode(STATE_CODE_CSV_FILE_PATH_WITH_WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals("Error capturing CSV header!", e.getMessage());
        }
    }
}






