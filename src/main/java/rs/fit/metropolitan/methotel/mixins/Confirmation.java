/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.methotel.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 *
 * @author Milan
 */
@Import(library="confirmation.js")
public class Confirmation {
    @Inject
    private JavaScriptSupport js;
    @InjectContainer
    private ClientElement element; 
    @Parameter(value = "Are you sure you want to delete this?", defaultPrefix = BindingConstants.LITERAL)
    private String message;
    
    @AfterRender
    public void afterRender() {
        js.addInitializerCall("confirmation", new JSONObject("id", this.element.getClientId(), "message", this.message));
    }
}