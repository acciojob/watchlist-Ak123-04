package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
       movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String director,String movie){
        movieRepository.addMovieDirectorPair(director,movie);
    }
    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){
        List<String>list=movieRepository.getMovieByDirectorName(name);
        List<String>finalList=new ArrayList<>();
        for(String s:list){
            finalList.add(s);
        }
        return finalList;
    }

    public List<String> getAllMovies(){
        List<String>allMovies=movieRepository.getAllMovies();
        return allMovies;
    }
    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
