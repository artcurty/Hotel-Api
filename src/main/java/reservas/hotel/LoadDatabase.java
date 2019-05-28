package reservas.hotel;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;


@Configuration
@Slf4j
public class LoadDatabase {

    private static int getRandomIntegerBetweenRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    private boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    // Populate Database
    @Bean
    CommandLineRunner initDatabase(HotelRepository hRepository, QuartoRepository qRepository, ClienteRepository cRepository){

        return args -> {
            // lista de companhias aereas

            List<String> nome_companhias = Arrays.asList("Azul Brazilian Airlines Azul Brazilian Airlines","Air France Air France ","Gol Transportes Aéreos Gol Transportes Aéreos ","LATAM Airlines Group SA LATAM Airlines Group SA ", "Avianca Brazil Avianca Brazil");

            List<String> uf_list = Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO");

            Faker faker = new Faker(new Locale("pt"));

            List<String> sex_list = Arrays.asList("Homem", "Mulher", "Outro");

            int num_ufs = uf_list.size();


        }

}
