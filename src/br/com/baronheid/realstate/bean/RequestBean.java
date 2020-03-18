package br.com.baronheid.realstate.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

import br.com.baronheid.realstate.entity.Request;

@ManagedBean
public class RequestBean {

	private Request request;
	private Locale locale;

	@PostConstruct // makes sure init() will only be used after the bean is completely ready;
	private void init() {
		this.request = new Request();
	}

	public void register() {
		System.out.println("City: " + request.getCity());
		System.out.println("Value: " + request.getValue());
		System.out.println("Description: " + request.getDescription());
		System.out.println("Password: " + request.getPassword());
		System.out.println("New: " + request.isNewRequest());
		System.out.println(request.getItems());
		System.out.println(request.getRooms());
		System.out.println(request.getType());
		System.out.println(request.getGoal());
		System.out.println(request.getOperation());
		System.out.println(request.getEmail());

		// Message will be associated with the component h:h:messages - due to this
		// being a simulation, it's not internationalized
		FacesMessage facesMessage = new FacesMessage("Realstate Registered!");

		// Adds the message at the current request instance
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	// Goes home
	public String goHome() {
		return "index?faces-redirect=true";
	}

	/**
	 * Returns true if the language is Portuguese. We use context once again, now to
	 * obtain the Locale
	 */
	private boolean getLocalePt() {
		this.locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		return locale.getLanguage().toString().equals("pt");
	}

	// Returns a list of types for the xhtml page, treating the multi language issue
	public List<String> getTypes() {
		List<String> list = new ArrayList<String>();

		if (getLocalePt()) {
			list.add("Casa");
			list.add("Apartmento");
			list.add("Armazém");
			list.add("Fazenda");
			list.add("Rancho");
		} else {
			list.add("House");
			list.add("Apartment");
			list.add("Depot");
			list.add("Farm");
			list.add("Ranch");
		}
		return list;
	}

	public List<String> getRoomsList() {
		List<String> lista = new ArrayList<String>();

		if (getLocalePt()) {
			lista.add("Quarto");
			lista.add("Sala");
			lista.add("Cozinha");
			lista.add("Banheiro");
			lista.add("Varanda");
		} else {
			lista.add("Bedroom");
			lista.add("Living room");
			lista.add("Kitchen");
			lista.add("Bathroom");
			lista.add("Balcony");
		}
		return lista;
	}
	
	public Request getRequest() {
		return this.request;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}

}
