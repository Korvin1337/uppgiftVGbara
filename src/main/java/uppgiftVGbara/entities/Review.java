package uppgiftVGbara.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    private String gameTitle;

    @Column
    private String reviewText;

    @Column
    private String reviewPlus;

    @Column
    private String reviewMinus;

    @Column
    /*@Size(min= 0, max= 5)*/
    private int ReviewScore;

    @ManyToOne
    @JoinColumn(name = "appuser_id")
    private AppUser appUser;

    public Review(String gameTitle, String reviewText, String reviewPlus, String reviewMinus, int reviewScore, AppUser appUser) {
        this.gameTitle = gameTitle;
        this.reviewText = reviewText;
        this.reviewPlus = reviewPlus;
        this.reviewMinus = reviewMinus;
        this.ReviewScore = reviewScore;
        this.appUser = appUser;
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewPlus() {
        return reviewPlus;
    }

    public void setReviewPlus(String reviewPlus) {
        this.reviewPlus = reviewPlus;
    }

    public String getReviewMinus() {
        return reviewMinus;
    }

    public void setReviewMinus(String reviewMinus) {
        this.reviewMinus = reviewMinus;
    }

    public int getReviewScore() {
        return ReviewScore;
    }

    public void setReviewScore(int reviewScore) {
        ReviewScore = reviewScore;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", reviewPlus='" + reviewPlus + '\'' +
                ", reviewMinus='" + reviewMinus + '\'' +
                ", ReviewScore=" + ReviewScore +
                ", appUser=" + appUser +
                '}';
    }
}