package com.example.restdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration //hace que se ejecute al iniciar la aplicacion
class LoadData {


    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(ActorRepository actorRepository, DirectorRepository directorRepository, CategoryRepository categoryRepository, TitleRepository titleRepository) {

        return args -> {

            /*RowCallbackHandler callback = new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    Arrays.stream(rs.getString("cast").split(", ")).forEach(a -> {
                        actorRepository.save(new Actor(a));
                    });
                }
            };
            jdbcTemplate.query("Select cast from netflix_titles", callback);

            RowCallbackHandler callback2 = new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    Arrays.stream(rs.getString("director").split(", ")).forEach(a -> {
                        directorRepository.save(new Director(a));
                    });
                }
            };
            jdbcTemplate.query("Select director from netflix_titles", callback2);

            RowCallbackHandler callback3 = new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    Arrays.stream(rs.getString("listed_in").split(", ")).forEach(a -> {
                        categoryRepository.save(new Category(a));
                    });
                }
            };
            jdbcTemplate.query("Select listed_in from netflix_titles", callback3);
            RowCallbackHandler callback4 = new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    //<Category> categorias = categoryRepository.findAllByNames(rs.getString("listed_in").split(", "));
                    //List<Director> directores = directorRepository.findAllByNames(rs.getString("director").split(", "));
                    //List<Actor> actores = actorRepository.findAllByNames(rs.getString("cast").split(", "));

                    titleRepository.save(
                            new Title(
                                    rs.getString("show_id"),
                                    rs.getString("type"),
                                    rs.getString("title"),
                                    rs.getString("country"),
                                    rs.getDate("date_added"),
                                    rs.getInt("release_year"),
                                    rs.getString("rating"),
                                    rs.getString("duration"),
                                    rs.getString("description")

                            )
                    );
                }
            };
            jdbcTemplate.query("Select * from netflix_titles", callback4);*/
            /*Director dir1 = new Director("paco perez");
            Director dir2 = new Director("elver galarga");

            Title title1 = new Title("peliculon", "Septiembre 12", "2021", "R", "mucho", "asdasd", 1, 4.0f);
            title1.setCast(new ArrayList<Actor>());
            title1.setListed_in(new ArrayList<Category>());
            List<Director> a = new ArrayList<Director>();
            a.add(dir1);
            a.add(dir2);
            title1.setDirectores(a);
            Title title2 = new Title("bartman", "Diciembre 123", "1954", "R-18", "123", "el barto", 3242, 8.6f);


            directorRepository.save(dir1);
            directorRepository.save(dir2);



            titleRepository.save(title1);

            titleRepository.save(title2);

            directorRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });
            titleRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });*/

            log.info("Preload complete");
        };
    }
}