package com.autodesk.zen.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.autodesk.zen.model.Hero;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/rest")
@Scope("request")
public class RestService {
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
		data.put("desc", hero.getDesc());
		return data.toString();
	}

    //////////////Test POST data:////////////////////
    //	{
	//		"name" : "Jack",
	//		"desc" : "Jack is a good boy",
	//		"inputs" : {
	//			"home": ["China", "US"],
	//			"number": 1388,
	//			"hobby": {
	//				"sport" : "Basketball"
	//			}
	//		}
	//	}
	/////////////////////////////////////////////////
	@POST
	@Path("/boy")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addHero(Hero hero) throws JSONException{
		// bindings
		String name = hero.getName();
		String desc = hero.getDesc();
		Map inputs = hero.getInputs();

		// test class mappings
		ArrayList home = (ArrayList)inputs.get("home"); //test array
		Integer number = (Integer)inputs.get("number");  //test number
		Map hobby = (Map)inputs.get("hobby");  //test map
		String sport = hobby.get("sport").toString();

		JSONObject data = new JSONObject();
		data.put("name", name);
		data.put("desc", desc);
		data.put("number", number);
		data.put("home1", home.get(0));
		data.put("home2", home.get(1));
		data.put("sport", sport);

		return data.toString();
	}
}
