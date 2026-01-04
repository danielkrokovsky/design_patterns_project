package design_pattern.template_method;

import java.util.List;

public class PdfDataMiner extends DataMiner{

	@Override
	protected String openFile(String path) {
		System.out.println("Open file Pdf");
		return path;
	}

	@Override
	protected List<String> extractData(String openFile) {
		System.out.println("extractData Pdf");
		return List.of(String.valueOf(openFile.toCharArray()));
	}

	@Override
	protected List<String> parseData(List<String> rawData) {
		System.out.println("parseData Pdf");
		return rawData;
	}	
}
