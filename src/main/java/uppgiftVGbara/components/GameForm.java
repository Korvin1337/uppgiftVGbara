package uppgiftVGbara.components;

import uppgiftVGbara.entities.Review;
import uppgiftVGbara.service.ReviewService;
import uppgiftVGbara.views.ManageReviewsView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class GameForm extends FormLayout {

    TextField gameTitle = new TextField("Game Title");
    TextArea reviewText = new TextArea("About The Game");
    TextField reviewPlus = new TextField("Positives");
    TextField reviewMinus = new TextField("Negatives");
    IntegerField reviewScore = new IntegerField("Score (0-5)");
    Button saveButton = new Button("Save");


    Binder<Review> binder = new BeanValidationBinder<>(Review.class);
    ReviewService reviewService;
    ManageReviewsView manageReviewsView;

    public GameForm(ReviewService reviewService, ManageReviewsView manageReviewsView) {
        this.reviewService = reviewService;
        this.manageReviewsView = manageReviewsView;
        binder.bindInstanceFields(this);
        setVisible(false);

        saveButton.addClickListener(evt -> handleSave(manageReviewsView));

        add(gameTitle, reviewText, reviewPlus, reviewMinus, reviewScore, saveButton);
    }

    private void handleSave(ManageReviewsView manageReviewsView) {
        Review review = binder.validate().getBinder().getBean();
        if(review.getId() == 0) {
            reviewService.save(review);
        }
        reviewService.updateById(review.getId(), review);
        setReview(null);
        manageReviewsView.updateItems();

        this.getParent().ifPresent(component -> {
            if(component instanceof Dialog) {
                ((Dialog) component).close();
            }
        });
    }

    public void setReview(Review review) {
        setVisible(false);
        if(review != null) {
            binder.setBean(review);
            setVisible(true);
        }
    }

}