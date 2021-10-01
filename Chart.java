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

	public void feedFile(String name, ArrayList<Double> in) {

		try {
			FileWriter myWriter = new FileWriter(name);
			for (Double a : in) {
				myWriter.write(a + " \n");
				// myWriter.write("\n");
			}
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Chart c = new Chart();

		ArrayList<Double> in = new ArrayList<Double>();
		in.add((double) 2);
		in.add((double) 0);
		// c.feedFile("A.txt", in);

		c.create("values.txt", "values.txt");
	}

}
