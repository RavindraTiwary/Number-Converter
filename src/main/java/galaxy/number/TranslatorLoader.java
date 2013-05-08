package galaxy.number;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TranslatorLoader {

	private List<String> definitions;
	private List<String> queries;
	private FileInputStream inputStream;

	public TranslatorLoader(FileInputStream inputStream) {
		this.inputStream = inputStream;
		this.definitions = new ArrayList<String>();
		this.queries = new ArrayList<String>();
		load();
	}

	private void load() {
		String line;
		try(BufferedReader input = new BufferedReader(new InputStreamReader(inputStream))){
			while((line = input.readLine()) != null){
				if (line.endsWith("?"))
					queries.add(line);
				else
					definitions.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public DefinitionParser getDefinitionParser() {
		return new DefinitionParser(definitions);
	}

	public List<String> getQueries() {
		return queries;
	}

}
