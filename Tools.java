import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used as a pocket knife in our project.
 * 
 * Here we have the implementation of every tools we need such as the sigmoid
 * function, weight generation or file IO handling
 * 
 * @author Michail - Panagiotis Bofos
 * @date 1/10/2021
 *
 */
public class Tools {
	static int counter = 0;
	static double[] w = { 0.1, 0.2, 0.4, 0.5, 0.9, 0.3, 0.6, 0.7, 0.8 };

	/**
	 * This function emulates the sigmoid function.
	 * 
	 * f(x) = 1 / ( 1 + e^(-a*x))
	 * 
	 * @param x double variable
	 * @return double value between zero and one
	 */
	public static double sigmoid(double x) {
		return (1 / (1 + Math.exp(-1.0 * x)));

	}

	/**
	 * This function generates random decimal numbers between minus one and one
	 * excluding zero.
	 * 
	 * @return double [-1,1] - {0}
	 */
	public static double randomWeight() {

		int max = 1, min = -1;
		double ran = 0.0;
		do {
			ran = Math.random() * (max - min) + min;
		} while (ran == 0.0);

		return ran;

	}

	/**
	 * This function generates specific numbers used in order to check the neural
	 * network.
	 * 
	 * @return double numbers
	 */
	public static double demoWeightsTwoTwoOne() {
		return w[counter++];

	}

	/**
	 * This function calculates the error of an output.
	 * 
	 * (0.5*Ó(target - real)^2)
	 * 
	 * @param tpj ArrayList<dDouble> target outputs
	 * @param opj ArrayList<dDouble> real outputs
	 * @return double value - error
	 */
	public static double error(ArrayList<Double> tpj, ArrayList<Double> opj) {
		double sum = 0;
		for (int i = 0; i < tpj.size(); i++) {
			sum += (tpj.get(i) - opj.get(i)) * (tpj.get(i) - opj.get(i));
		}
		return 0.5 * sum;

	}

	/**
	 * This function reads a parameter file and fills an arraylist with the data.
	 * 
	 * @param filename
	 * @return ArrayList<String> containing the file data
	 */
	public static ArrayList<String> getParameters(String filename) {
		ArrayList<String> list = new ArrayList<>();
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int cnt = 0;
			while (myReader.hasNextLine()) {
				cnt++;
				String data = myReader.next();
				// System.out.println(data);
				if (cnt == 2) {
					list.add(data);
					cnt = 0;
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * This function reads a file and fills two arraylists (of double arrays) with
	 * the training/testing data.
	 * 
	 * @param filename
	 * @param inputs   ArrayList<double[]>
	 * @param outputs  ArrayList<double[]>
	 */
	public static void fillData(String filename, ArrayList<double[]> inputs, ArrayList<double[]> outputs) {
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			int cnt = 0;
			int in = inputs.size(), out = outputs.size();
			while (myReader.hasNextLine()) {
				for (int i = 0; i < in; i++)
					inputs.get(i)[cnt] = myReader.nextInt() * 1.0;
				for (int i = 0; i < out; i++)
					outputs.get(i)[cnt] = myReader.nextInt() * 1.0;
				cnt++;

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	/**
	 * This function counts the lines of a file.
	 * 
	 * @param filename
	 * @return # of lines
	 */
	public static int findLines(String filename) {
		int cnt = 0;
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				cnt++;
				myReader.nextLine();

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return cnt;
	}

}
