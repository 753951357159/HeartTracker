import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReportManager {
	
	private static ReportManager instance;
	private final String csv = "data/reports.txt";  // File path for storing data
	private List<Report> reports;
	
	private ReportManager() {
		reports = new ArrayList<Report>();
	}
	
	public static synchronized ReportManager getInstance() {
		if (instance == null) {
			instance = new ReportManager();
		}
		return instance;
	}
	
	/**
	 * Adds a report to the list of reports.
	 * @param report - The report to add
	 */
	public void addReport(Report report) {
		this.reports.add(report);
	}
	
	/**
	 * Gets the list of reports.
	 * @return The list of reports.
	 */
	public List<Report> getReports() {
		return reports;
	}
	
	/**
	 * Saves all current data to a specified file.
	 * @throws IOException
	 */
	protected void saveToFile() {
		OutputStream file;
		
		try {
			file = new FileOutputStream(csv);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			
			output.writeObject(reports);
			output.close();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads all saved data from a specified file and store in reports.
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected void readFromCSVFile(){
		InputStream file;
		
		try {
			file = new FileInputStream(csv);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
		
			this.reports = (List<Report>) input.readObject();
			
			input.close();
			file.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
