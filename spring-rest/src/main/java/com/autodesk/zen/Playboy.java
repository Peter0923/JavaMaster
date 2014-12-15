package com.autodesk.zen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Path("/rest")
@Scope("request")
public class Playboy {
	private Hero hero;

	public void setHero(final Hero hero) {
		this.hero = hero;
	}

	@GET
	@Path("/boy")
	@Produces(MediaType.TEXT_PLAIN)
	public String showBoy() {
		return "Hello, this is Peter!";
	}

	@GET
	@Path("/hero")
	@Produces(MediaType.APPLICATION_JSON)
	public String showHero() throws JSONException {
		JSONObject data = new JSONObject();
		data.put("name", hero.getName());
		data.put("Desc", hero.getDesc());
		return data.toString();
	}
}
