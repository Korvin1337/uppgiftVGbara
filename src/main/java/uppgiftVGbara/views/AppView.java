package uppgiftVGbara.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import uppgiftVGbara.security.PrincipalUtil;

public class AppView extends AppLayout {

    public AppView() {

        HorizontalLayout navbarLayout = new HorizontalLayout();

        navbarLayout.add(new DrawerToggle(), new H1("WELCOME TO TECHNICAL SUPPORT!!!"));

        Button loginButton = new Button("Login", evt -> UI.getCurrent().navigate(LoginView.class));
        Button logoutButton = new Button("Logout", evt -> PrincipalUtil.logout());
        navbarLayout.add(PrincipalUtil.isAuthenticated() ? logoutButton : loginButton);

        if(PrincipalUtil.isAuthenticated())
            Notification.show(PrincipalUtil.getName());

        navbarLayout.setWidthFull();
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        navbarLayout.setMargin(true);

        addToNavbar(navbarLayout);

        RouterLink gameView = new RouterLink("View Games", GameView.class);
        RouterLink reviewView = new RouterLink("View Reviews", ReviewView.class);
        RouterLink manageReviewsView = new RouterLink("Mange Reviews", ManageReviewsView.class);

        VerticalLayout sideBarContent = new VerticalLayout(gameView, reviewView);
        if(PrincipalUtil.isAuthenticated())
            sideBarContent.add(manageReviewsView);

        addToDrawer(sideBarContent);


    }


}
