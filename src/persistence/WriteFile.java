package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import com.google.gson.Gson;

public class WriteFile<T>{

	private BufferedWriter bw;
	private Gson gson;
	
	public void writeFileArray(ArrayList<T> lista, String nameFile) throws JSONException, IOException {
		gson = new Gson();
		String json = gson.toJson(lista);
		File file = new File(nameFile);
		bw = new BufferedWriter(new FileWriter(file));
		if(file.exists()) {
			bw.write(json);
		}
		else {
			file.createNewFile();
			bw.write(json);
		}
		bw.close();
	}
}