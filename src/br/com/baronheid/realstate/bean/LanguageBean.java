package br.com.baronheid.realstate.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5633905815906228626L;

	private Locale locale;

	// Makes sure that locale is set only after the bean is completely filled.
	@PostConstruct
	private void init() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	/**
	 * Gets the current instance context, root view and sets the Language locale to english and loads it onto the view
	 */
	public void switchToEnglish() {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		locale = Locale.ENGLISH;
		view.setLocale(locale);
	}

	/**
	 * Same as the one before. Switches to Portuguese
	 */
	public void switchToPortuguese() {

		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		locale = new Locale("pt", "BR");
		view.setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
