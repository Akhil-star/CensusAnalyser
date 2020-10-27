package com.cg.census;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;


public class StateCensusAnalyser <T> {

    public int loadCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader( Paths.get(csvFilePath));
            CsvToBeanBuilder<StateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(StateCensus.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true).withSeparator(',');
            CsvToBean<StateCensus> csvToBean = csvToBeanBuilder.build();
            Iterator<StateCensus> censusCSVIterator = csvToBean.iterator();
            Iterable<StateCensus> csvIterable = () -> censusCSVIterator;
            int numOfRecords = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfRecords;
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}
