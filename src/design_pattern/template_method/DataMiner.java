package design_pattern.template_method;

import java.util.List;

public abstract class DataMiner {

	public void mine(String path) {
		
		var openFile = this.openFile(path);
		var rawData = this.extractData(openFile);
		var data = this.parseData(rawData);
		String analyseData = this.analyzeData(data);
		this.sendReport(analyseData);
	}
	
	protected abstract String openFile(String path);
	
	protected abstract List<String> extractData(String openFile);

	protected abstract List<String> parseData(List<String> rawData);
	

	public String analyzeData(List<String> path) {

		return "Analisando dados";
	}

	public void sendReport(String analyseData) {

		System.out.print("Enviando relatório");

	}
}
