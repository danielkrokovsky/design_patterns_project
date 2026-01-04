package design_pattern.template_method;

public class TemplateMethodMain {
	
	public static void main(String[] args) {
		
		String path = "tmp/testee.pdf";
		DataMiner dtm = new PdfDataMiner();
		dtm.mine(path);
		
		System.out.println("");
		System.out.println("--------- --------------");
		
		DataMiner dtmCsv = new CsvDataMiner();
		dtmCsv.mine(path);
		
		System.out.println("");
		System.out.println("------------------ ----------------");
		
		DataMiner dtmDoc = new DocDataMiner();
		dtmDoc.mine(path);
	}
}
