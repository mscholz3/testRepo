package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSonFileIO {
	private final Gson	gson;

	public JSonFileIO() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public void writeMapToJSon(final Object obj) {
		final String json = gson.toJson(obj);
		System.out.println(json);
	}

}
