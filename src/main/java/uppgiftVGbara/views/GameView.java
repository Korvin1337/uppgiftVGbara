package uppgiftVGbara.views;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import uppgiftVGbara.service.GameService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@AnonymousAllowed
@Route(value = "/", layout = AppView.class)
public class GameView extends VerticalLayout {

    public GameView(GameService gameService) {

        add(new H2("Games"));
        add(new Hr());
        add(new Hr());

        setAlignItems(Alignment.CENTER);

        gameService.findAll().forEach(game -> {


            H2 gameTitle = new H2(game.getGameTitle());
            H4 gameDeveloper = new H4("Developer: " + game.getGameDeveloper());
            H4 gameReleaseYear = new H4("Release Year: " + game.getReleaseYear());

            add(gameTitle, gameDeveloper, gameReleaseYear, new Hr(), new Hr());


        });


    }


}
