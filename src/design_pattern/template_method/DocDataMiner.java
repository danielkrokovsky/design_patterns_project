package design_pattern.template_method;

import java.util.List;

public class DocDataMiner extends DataMiner{

	@Override
	protected String openFile(String path) {
		System.out.println("Open file DOC");
		return "tmp/testee.doc";
	}

	@Override
	protected List<String> extractData(String openFile) {
		System.out.println("extractData DOC");
		return List.of(String.valueOf(openFile.toCharArray()));
	}

	@Override
	protected List<String> parseData(List<String> rawData) {
		System.out.println("parseData DOCV");
		return rawData;
	}	
}
