import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Chart {

	public void create(String file1, String file2) {
		try {
			Runtime.getRuntime().exec("python  2plots.py " + file1 + " " + file2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void create(String file1) {

		try {
			Runtime.getRuntime().exec("python  plot.py " + file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void feedFile(String name, ArrayList<String> in) {

		try {
			FileWriter myWriter = new FileWriter(name);
			for (String a : in) {
				myWriter.write(a);
				myWriter.write("\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Chart c = new Chart();

		ArrayList<String> in = new ArrayList<String>();
		in.add("AS");
		// in.add("\n");
		in.add("ASA");
		c.feedFile("a.txt", in);
	}

}