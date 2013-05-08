package galaxy.number;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GalaxyCurrencyTranslator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.err.println("You need to provide the file path");
			System.exit(-1);
		}
		
		TranslatorLoader translatorLoader = null;
		try {
			translatorLoader = new TranslatorLoader(new FileInputStream(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			System.exit(-1);
		}
		DefinitionParser definitionParser = translatorLoader.getDefinitionParser();
		QueryValidation queryValidation = new QueryValidation();
		for (String query : translatorLoader.getQueries()) {
			System.out.println(Query.create(definitionParser, queryValidation, query).ask());
		}
	}

}
