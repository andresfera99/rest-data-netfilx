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
            /*Type aux1 = new Type("tipo h2 prueba");
            typeRepository.save(aux1);

            typeRepository.save(new Type("tipo h2 prueba 2"));
            Type aux2 = new Type("tipo h2 prueba 3");
            typeRepository.save(aux2);


            typeRepository.save(new Type("tipo h2 prueba 3")); // para darle los vinos de prueba

            Winery aux3 = new Winery("vineria tupac");
            wineryRepository.save(aux3);
            //delete
            wineryRepository.save(new Winery("vineria chikibeibi"));
            Winery aux4 = new Winery("vineria chikibeibi 123");
            wineryRepository.save(aux4);

            wineryRepository.save(new Winery("vineria prueba 3")); // para darle los vinos de prueba

            Region aux5 = new Region("tierra media", "Hispania");
            regionRepository.save(aux5);
            Region aux6 = new Region("Jerusalem", "Por africa del este"); //delete
            regionRepository.save(aux6);
            Region aux7 = new Region("ALibaba", "Por africa del este");
            regionRepository.save(aux7);

            regionRepository.save(new Region("region prueba 3", "Hispania")); // para darle los vinos de prueba

            wineRepository.save(new Wine("vino1", "2022", 21365, 2.5f, 2, "5", "54", aux3, aux1, aux7));
            wineRepository.save(new Wine("vino2", "2025", 565, 7.5f, 648, "56", "985", aux3, aux1, aux7));
            wineRepository.save(new Wine("vino borrar", "2028", 565, 7.5f, 648, "56", "985", aux4, aux2, aux7));


            wineryRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });
            regionRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });
            typeRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });
            wineRepository.findAll().forEach(t -> {
                log.info(t.toString());
            });*/

            log.info("Preload complete");
        };
    }
}