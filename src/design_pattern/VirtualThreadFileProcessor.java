package design_pattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class VirtualThreadFileProcessor {

	private static final int CHUNK_SIZE = 1000; // Número de linhas por chunk

	public void processLargeFile(String filePath) throws IOException {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

			String s = "Data8277.csv";

			File f = new File(s);
			f.exists();

			try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
				CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

				List<CSVRecord> chunk = new ArrayList<>();
				for (CSVRecord record : csvParser) {
					chunk.add(record);
				}
				
				processChunk(chunk);
			}
		}
	}

	private void processChunk(List<CSVRecord> chunk) throws IOException {
		
		Path filePath = Paths.get("teste.csv");
		
		
		if(!Files.exists(filePath)) {
			Files.createFile(filePath);
		}
		
		String[] HEADERS = {"Year", "Age", "Ethnic", "Sex", "Area", "count"};
		
		CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .build();
		
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("teste.csv"))) {
			
            try (CSVPrinter csvPrinter = new CSVPrinter(writer, format)) {
				chunk.forEach(record -> {
					try {
						csvPrinter.printRecord(record);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				csvPrinter.flush();
			}
		}
	}

	public static void main(String[] args) throws IOException {
			
		new VirtualThreadFileProcessor().processLargeFile("");
	}
}