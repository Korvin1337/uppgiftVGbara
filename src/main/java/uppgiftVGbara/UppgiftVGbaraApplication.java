package uppgiftVGbara;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import uppgiftVGbara.entities.AppUser;
import uppgiftVGbara.entities.Game;
import uppgiftVGbara.entities.Review;
import uppgiftVGbara.repositorys.AppUserRepository;
import uppgiftVGbara.repositorys.GameRepository;
import uppgiftVGbara.repositorys.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UppgiftVGbaraApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UppgiftVGbaraApplication.class, args);
    }


    @Bean
    CommandLineRunner init(AppUserRepository appUserRepository, GameRepository gameRepository, ReviewRepository reviewRepository) {
        return args -> {

            /*AppUser Gunnar = new AppUser("Gunnar", passwordEncoder.encode("pass"));
            AppUser Alice = new AppUser("Alice", passwordEncoder.encode("pass"));
            appUserRepository.saveAll(List.of(Gunnar, Alice));

            Game fifa22 = new Game("FIFA 22", "EA", 2021);
            Game eldenRing = new Game("Elden Ring", "From Software", 2022);
            gameRepository.saveAll(List.of(fifa22, eldenRing));

            Review fifa22Review = new Review("FIFA 22", "Gillar Inte Fifa", "Inget", "Allt", 0, Gunnar);
            Review eldenRingReview = new Review("Elden Ring", "Gillar Elden Ring", "Allt", "Inget", 4, Alice);
            reviewRepository.saveAll(List.of(fifa22Review, eldenRingReview));*/
            


        };
    }
}
