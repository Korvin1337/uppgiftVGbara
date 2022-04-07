package uppgiftVGbara.views;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import uppgiftVGbara.service.ReviewService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@AnonymousAllowed
@Route(value = "/reviews", layout = AppView.class)
public class ReviewView extends VerticalLayout {

    public ReviewView(ReviewService reviewService) {

        add(new H2("Reviews"));

        setAlignItems(Alignment.CENTER);

        reviewService.findAll().forEach(review -> {

            H2 gameTitle = new H2(review.getGameTitle());

            H4 reviewTextHeader = new H4("About The Game");
            Paragraph reviewText = new Paragraph(review.getReviewText());
            H4 reviewPlusHeader = new H4("Positives");
            Paragraph reviewPlus = new Paragraph(review.getReviewPlus());
            H4 reviewMinusHeader = new H4("Negatives");
            Paragraph reviewMinus = new Paragraph(review.getReviewMinus());
            H4 reviewScoreHeader = new H4("Rating");
            Paragraph reviewScore = new Paragraph("Score: " + String.valueOf(review.getReviewScore()) + "/5");

            Paragraph writtenBy = new Paragraph("Written by: ");
            Span author = new Span(review.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            writtenBy.add(author);

            add(new Hr(), new Hr(), gameTitle, new Hr(),  new Hr(), reviewTextHeader, reviewText, new Hr(), reviewPlusHeader, reviewPlus, new Hr(), reviewMinusHeader, reviewMinus, new Hr(), reviewScoreHeader, reviewScore, writtenBy, new Hr());

        });



    }




}