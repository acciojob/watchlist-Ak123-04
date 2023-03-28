package com.driver;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie>movieDB=new HashMap<>();
    HashMap<String,Director>directorDB=new HashMap<>();
    HashMap<String, List<String>>director_moviePairDB=new HashMap<>();

    public void addMovie(Movie movie){
        String name=movie.getName();
        movieDB.put(name,movie);
    }

    public void addDirector(Director director){
        String name=director.getName();
        directorDB.put(name,director);
    }
    public  void addMovieDirectorPair(String director,String movie){
        if(director_moviePairDB.containsKey(director)){
            List<String>movieName=director_moviePairDB.get(director);
            movieName.add(movie);
            director_moviePairDB.put(director,movieName);
        }
        else{
        List<String>movieName=new ArrayList<>();
        movieName.add(movie);
        director_moviePairDB.put(director,movieName);
        }
    }
    public Movie getMovieByName(String name){
        return movieDB.get(name);
    }
    public Director getDirectorByName(String name){
        return directorDB.get(name);
    }
    public List<String> getMovieByDirectorName(String name){
        List<String>list=director_moviePairDB.get(name);
        return list;
    }
    public List<String>getAllMovies(){
        List<String>movieList=new ArrayList<>();
        movieList.addAll(movieDB.keySet());
        return movieList;
    }
    public void deleteDirectorByName(String name){
        List<String>list=director_moviePairDB.get(name);
        for(String d:list){
            movieDB.remove(name);
        }
        directorDB.remove(name);
        director_moviePairDB.remove(name);
    }
    public void deleteAllDirectors() {
        for (List<String> list : director_moviePairDB.values()) {
            for (String m : list) {
                movieDB.remove(m);
            }
        }
            directorDB.clear();
            director_moviePairDB.clear();
        }


}
