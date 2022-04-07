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

        add(new H1("Reviews"));

        setAlignItems(Alignment.CENTER);

        reviewService.findAll().forEach(review -> {

            H1 gameTitle = new H1(review.getGameTitle());

            H3 reviewTextHeader = new H3("About The Game");
            Paragraph reviewText = new Paragraph(review.getReviewText());
            H3 reviewPlusHeader = new H3("Positives");
            Paragraph reviewPlus = new Paragraph(review.getReviewPlus());
            H3 reviewMinusHeader = new H3("Negatives");
            Paragraph reviewMinus = new Paragraph(review.getReviewMinus());
            H3 reviewScoreHeader = new H3("Rating");
            Paragraph reviewScore = new Paragraph("Score: " + String.valueOf(review.getReviewScore()) + "/5");

            Paragraph writtenBy = new Paragraph("Written by: ");
            Span author = new Span(review.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            writtenBy.add(author);

            add(new Hr(), gameTitle, reviewTextHeader, reviewText, reviewPlusHeader, reviewPlus, reviewMinusHeader, reviewMinus, reviewScoreHeader, reviewScore, writtenBy, new Hr(), new Hr());

        });



    }




}