package rs.fit.metropolitan.methotel.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SymbolConstants;
import rs.fit.metropolitan.methotel.entities.Korisnik;

/**
 * Layout component for pages of application test-project.
 */
@Import(module="bootstrap/collapse")
public class Layout
{
	@Inject
	private ComponentResources resources;

	/**
	 * The page title, for the <title> element and the <h1> element.
	 */
	@Property
	@Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
	private String title;

	@Property
	private String pageName;

	@Property
	@Inject
	@Symbol(SymbolConstants.APPLICATION_VERSION)
	private String appVersion;
        @SessionState
        private Korisnik ulogovanKorisnik;


	public String getClassForPageName()
	{
		return resources.getPageName().equalsIgnoreCase(pageName)
				? "active"
				: null;
	}

	public String[] getPageNames()
	{
		return new String[]{"Index", "About", "Contact"};
	}
        
        public boolean getLoggedIn() {
            if (ulogovanKorisnik.getKorisnikEmail() != null) {
                System.out.println("~~" + ulogovanKorisnik.getKorisnikIme());
                return true;
            }
            return false;
        }
        
        public void onActionFromLogout() {
            ulogovanKorisnik = null;
        }

}
