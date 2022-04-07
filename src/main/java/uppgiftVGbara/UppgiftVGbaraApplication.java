package uppgiftVGbara;

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
    AppUserRepository appUserRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(UppgiftVGbaraApplication.class, args);
    }


    @Bean
    CommandLineRunner init(AppUserRepository appUserRepository, GameRepository gameRepository, ReviewRepository reviewRepository) {
        return args -> {

            AppUser Gunnar = new AppUser("Gunnar");
            AppUser Alice = new AppUser("Alice");
            appUserRepository.saveAll(List.of(Gunnar, Alice));

            Game fifa22 = new Game("FIFA 22", "EA", 2021);
            Game eldenRing = new Game("Elden Ring", "Japanese", 2022);
            gameRepository.saveAll(List.of(fifa22, eldenRing));

            Review fifa22Review = new Review("Fifa Suger", "Gillar Inte Fifa", "Inget", "Allt", 0, Gunnar.getUsername());
            Review eldenRingReview = new Review("Elden Ring Bra", "Gillar Elden Ring", "Allt", "Inget", 4, Alice.getUsername());
            reviewRepository.saveAll(List.of(fifa22Review, eldenRingReview));


        };
    }
}
