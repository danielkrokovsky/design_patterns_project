package design_pattern.template_method;

import java.util.List;

public class CsvDataMiner extends DataMiner{

	@Override
	protected String openFile(String path) {
		System.out.println("Open file CSV");
		return "tmp/testee.csv";
	}

	@Override
	protected List<String> extractData(String openFile) {
		System.out.println("extractData CSV");
		return List.of(String.valueOf(openFile.toCharArray()));
	}

	@Override
	protected List<String> parseData(List<String> rawData) {
		System.out.println("parseData CSV");
		return rawData;
	}	
}
