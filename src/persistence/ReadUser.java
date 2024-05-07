package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.User;

public class ReadUser{
	
	private BufferedReader br;
	private Gson gson;
	private File file;

	public ArrayList<User> readFile(String path) throws IOException, JSONException{
		file = new File(path);
		ArrayList<User> lista = null;
		if(file.exists()) {
			lista = this.readFileArray();
			return lista;
		}
		else {
			file.createNewFile();
			lista = new ArrayList<User>();
			WriteFile<User> wf = new WriteFile<User>();
			wf.writeFileArray(lista, "data/user.json");
			return lista;
		}
	}
	
	public ArrayList<User> readFileArray() throws IOException{
		ArrayList<User> lista = new ArrayList<User>();
		StringBuilder json = new StringBuilder();
		gson = new Gson();
		br = new BufferedReader(new FileReader(file));
		String linea = "";
		while((linea = br.readLine()) != null)
			json.append(linea);
		lista = gson.fromJson(json.toString(), new TypeToken<ArrayList<User>>(){}.getType());
		br.close();
		file.createNewFile();
		if(lista != null)
			return lista;
		else
			return new ArrayList<User>();
	}
}