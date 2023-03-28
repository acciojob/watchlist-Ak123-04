package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return  new ResponseEntity<>("movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String>addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String director,@RequestParam String movie){
    movieService.addMovieDirectorPair(director,movie);
    return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name){
        Movie movie=null;
        movie=movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable("name")String name){
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name){
        List<String> movies=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies(){
        List<String> allmovies=movieService.getAllMovies();
        return new ResponseEntity<>(allmovies,HttpStatus.CREATED);
    }
     @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        movieService.deleteDirectorByName(name);
        return  new ResponseEntity<>("successfully deleted",HttpStatus.CREATED);
     }
     @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("successfully deleted record",HttpStatus.CREATED);
     }
}
