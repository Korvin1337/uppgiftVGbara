package uppgiftVGbara.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import uppgiftVGbara.entities.AppUser;
import uppgiftVGbara.repositorys.AppUserRepository;

@Service
public class PrincipalUtil {

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser getLoggedInAppUser() {
        return appUserRepository.findAppUserByUsername(getName()).orElseThrow();
    }

    public static boolean isAuthenticated() {
        return !SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("anonymousUser");
    }

    public static void logout() {
        UI.getCurrent().navigate("/");
        new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
    }

    public static String getName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
