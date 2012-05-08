package security;

import domain.*;
import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rodrigo
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    // Log support
    private static final Logger log = LoggerFactory.getLogger(
            LoginBean.class);
    
    @Inject
    crud.Crud crud;
    
    @Inject
    Preferences preferences;

    String username;
    String password;

    public void login() {

        // Get the request
        HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().getRequest();

        try {
            
            // Attempt login
            request.login(username, password);
        
            // Get user
            Principal principal = request.getUserPrincipal();

            // Find the User instance
            User userObj = crud.find("getUser", principal.getName());
            log.info("User {} is logged in", principal.getName());

            // Create outjected object
            user.setUserEntity(userObj);
            user.setLoginTimestamp(new Date());

            // Log if the user is an administrator too
            if (request.isUserInRole("admin-role")) {
                log.info("User {} is an administrator", principal.getName());
            }

            // Redirect to home page and continue from there
            FacesContext.getCurrentInstance().getExternalContext().
                    redirect("home.jsf");

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            try {
                request.logout();
            } catch (Exception e2) {
            }
        }

    }

    public String home() {
        return "/home.jsf";
    }

    public void logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().
                getRequest();
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            user.setLoginTimestamp(null);
            request.logout();
            ctx.getExternalContext().invalidateSession();
            ctx.getExternalContext().redirect("/master/login.jsf");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
