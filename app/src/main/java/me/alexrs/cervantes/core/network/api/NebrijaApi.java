package me.alexrs.cervantes.core.network.api;

import me.alexrs.cervantes.core.datamodel.Nebrija;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Alejandro Rodriguez <https://github.com/Alexrs95/Cervantes>
 */
public interface NebrijaApi {

    @GET("/api/random?type=day")
    Nebrija getDailyWord();

    @GET("/api/random?type=random")
    Nebrija getRandomWord();

    @GET("/api/random")
    Nebrija getWord(@Query("query") String word);
}
