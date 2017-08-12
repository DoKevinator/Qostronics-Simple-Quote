
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.io.*;



public class Quote {

	static final int STAGE = 5;

	public enum PARTS {
		PASSIVE_PART (1),
		SOIC (2),
		SOT (3),
		QFP_80_LT (4),
		QFP_80_GT (5),
		QFN_LF (6),
		FBGA_SBGA (7),
		SMT_POWER_MODULES (8),
		PIN_HEADER (9),
		SMA (10),
		PLCC (11),
		BGA_SMALL (12),
		CCGA_BGA_256_GT (13),
		TSOP (14),
		SW_RELAY_LARGE_INDUCTOR (15),
		SHIELDS (16),
		CONNECTOR_5_MINUS_20_PIN (17),
		CONNECTOR_20_PLUS_PIN (18),
		SMT_HP (19),
		STAMPS (20),
		JUMPER (21),
		JUMPER_3IN (22),
		JUMPER_5IN (23),
		TCUTS (24),
		LEG_LIFT (25),
		KEPTON_MASK (26),
		PACKAGING (27),
		BOM_LINE_ITEM_COUNT (28),
		SETUP (29);

		private int numVal;

	    PARTS(int numVal) {
	        this.numVal = numVal;
	    }

	    public int getNumVal() {
	        return numVal;
	    }
	}

	//initialize constants based on stage
	//stage is the total number of board qty. (e.g. 1-50, 50-100, etc.)
	//stage 1: 1-5
	//stage 2: 6-10
	//stage 3: 11-25
	//stage 4: 26-50
	//stage 5: 51-100
	public static ArrayList<Double> init_constants(int stage) {
		ArrayList<Double> constants = new ArrayList<Double>();

		switch(stage) {
			case 1: 
				constants.add(0.35);
				constants.add(0.8);
				constants.add(0.55);
				constants.add(1.85);
				constants.add(4.0);
				constants.add(2.5);
				constants.add(3.25);
				constants.add(1.5);
				constants.add(0.5);
				constants.add(1.0);
				constants.add(1.0);
				constants.add(5.0);
				constants.add(6.0);
				constants.add(1.5);
				constants.add(0.75);
				constants.add(1.5);
				constants.add(0.85);
				constants.add(1.6);
				constants.add(1.2);
				constants.add(0.0);
				constants.add(1.5);
				constants.add(2.75);
				constants.add(3.0);
				constants.add(1.75);
				constants.add(1.25);
				constants.add(1.0);
				constants.add(1.0);
				constants.add(0.0);
				constants.add(1.0);
				break;

			case 2:
				constants.add(0.25);
				constants.add(0.8);
				constants.add(0.35);
				constants.add(1.5);
				constants.add(2.0);
				constants.add(2.0);
				constants.add(3.0);
				constants.add(1.2);
				constants.add(10.0);
				constants.add(1.0);
				constants.add(1.0);
				constants.add(5.0);
				constants.add(6.0);
				constants.add(1.0);
				constants.add(0.65);
				constants.add(1.25);
				constants.add(0.75);
				constants.add(1.5);
				constants.add(0.9);
				constants.add(0.0);
				constants.add(1.5);
				constants.add(2.35);
				constants.add(2.35);
				constants.add(1.5);
				constants.add(0.85);
				constants.add(1.0);
				constants.add(1.0);
				constants.add(0.0);
				constants.add(0.0);
				break;

			case 3:
				constants.add(0.2);
				constants.add(0.7);
				constants.add(0.25);
				constants.add(1.25);
				constants.add(1.5);
				constants.add(1.5);
				constants.add(2.5);
				constants.add(1.0);
				constants.add(0.35);
				constants.add(1.0);
				constants.add(0.75);
				constants.add(3.0);
				constants.add(4.0);
				constants.add(0.75);
				constants.add(0.5);
				constants.add(1.0);
				constants.add(0.5);
				constants.add(1.0);
				constants.add(0.6);
				constants.add(0.0);
				constants.add(1.5);
				constants.add(1.75);
				constants.add(2.15);
				constants.add(1.25);
				constants.add(0.62);
				constants.add(0.0);
				constants.add(1.0);
				constants.add(0.0);
				constants.add(0.0);
				break;

			case 4:
				constants.add(0.17);
				constants.add(0.5);
				constants.add(0.25);
				constants.add(1.0);
				constants.add(1.25);
				constants.add(1.25);
				constants.add(2.0);
				constants.add(1.0);
				constants.add(0.3);
				constants.add(0.75);
				constants.add(0.75);
				constants.add(2.0);
				constants.add(3.0);
				constants.add(0.5);
				constants.add(0.5);
				constants.add(1.0);
				constants.add(0.4);
				constants.add(0.75);
				constants.add(0.5);
				constants.add(0.0);
				constants.add(1.5);
				constants.add(1.75);
				constants.add(2.15);
				constants.add(1.25);
				constants.add(0.62);
				constants.add(0.0);
				constants.add(1.0);
				constants.add(0.0);
				constants.add(0.0);
				break;

			case 5:
				constants.add(0.12);
				constants.add(0.5);
				constants.add(0.15);
				constants.add(1.1);
				constants.add(1.85);
				constants.add(1.5);
				constants.add(2.0);
				constants.add(0.65);
				constants.add(0.0);
				constants.add(0.0);
				constants.add(0.5);
				constants.add(2.25);
				constants.add(4.5);
				constants.add(0.45);
				constants.add(0.15);
				constants.add(0.8);
				constants.add(0.75);
				constants.add(0.9);
				constants.add(0.3);
				constants.add(0.0);
				constants.add(1.0);
				constants.add(1.5);
				constants.add(1.95);
				constants.add(1.0);
				constants.add(0.4);
				constants.add(0.6);
				constants.add(0.27);
				constants.add(0.0);
				constants.add(0.0);
				break;

			default:
				System.out.println("ERROR: STAGE NOT SPECIFIED. TERMINAING PROGRAM...");
				System.out.println("error code: 1");
				System.exit(1);
		}

		return constants;
	}

	
	//use constants along with formula to determine the cost based on stage
	public static ArrayList<Double> calculate_item_costs(int stage, ArrayList<Integer> qty_each) {
		//initialize constants based on STAGE
		ArrayList<Double> constants = init_constants(stage+1);
		
		ArrayList<Double> result_price =  new ArrayList<Double>();

		for( int i = 0; i < qty_each.size(); i++ ) {
			double price = qty_each.get(i) * constants.get(i);

			price = Math.floor(price * 100) / 100;
			result_price.add( price );
		}
		

		//TODO: finish this function

		return result_price;
	}

	public static ArrayList<Integer> read_item_qtys(String textfile) {
		ArrayList<Integer> item_qtys = new ArrayList<Integer>();

		// The name of the file to open.
        String fileName = textfile;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                //parse lines by ":"
				String[] parts = line.split(":");
				String item_part = parts[0];	//ex: "1. passive part"
				String qty_part_string = parts[1];		//ex: "20"
				qty_part_string = qty_part_string.replaceAll("\\s","");	//remove all whitespace
				int qty_part = Integer.parseInt(qty_part_string);	//convert to integer

				//split item_part by "." to get index
				String[] item_parts = item_part.split("\\.");
				String index_string = item_parts[0];	//ex: "1"
				String item = item_parts[1];		//ex: "passive part"
				index_string = index_string.replaceAll("\\s","");	//remove all whitespace
				int index = Integer.parseInt(index_string);		//convert to integer

				item_qtys.add(index-1, qty_part);	//add part quantity to arraylist

            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        return item_qtys;
    
	}

	public static boolean print_to_file(String filename, 
							  ArrayList<Integer> item_qtys, 
							  ArrayList< ArrayList<Double> > item_costs) {

		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");

			int i = 0;
			int stage = 0;
			double total = 0.0;
			PARTS[] parts = PARTS.values();

			writer.println("==================================================");
			writer.printf("%30s\n","BOARD QUANTITY: 1 to 5");
			writer.printf("%-27s %3s %12s\n", "Component", "Quantity", "Cost");
			writer.printf("%-27s %3s %12s\n", "---------", "--------", "----");
			for( PARTS part : parts ) {
				writer.printf("%-30s %3d", part.name(), item_qtys.get(i));
				writer.printf("%15.2f\n", item_costs.get(stage).get(i));
				total += item_costs.get(stage).get(i);
				i++;
			}
			writer.printf("%43s", "Total: ");
			writer.printf("%.2f\n", total);
			writer.println("==================================================");

			//reset the index, total, and increment stage
			i = 0;
			stage++;
			total = 0.0;

			writer.printf("%30s\n","BOARD QUANTITY: 6 to 10");
			writer.printf("%-27s %3s %12s\n", "Component", "Quantity", "Cost");
			writer.printf("%-27s %3s %12s\n", "---------", "--------", "----");
			for( PARTS part : parts ) {
				writer.printf("%-30s %3d", part.name(), item_qtys.get(i));
				writer.printf("%15.2f\n", item_costs.get(stage).get(i));
				total += item_costs.get(stage).get(i);
				i++;
			}
			writer.printf("%43s", "Total: ");
			writer.printf("%.2f\n", total);
			writer.println("==================================================");

			i = 0;
			stage++;
			total = 0.0;

			writer.printf("%30s\n","BOARD QUANTITY: 11 to 25");
			writer.printf("%-27s %3s %12s\n", "Component", "Quantity", "Cost");
			writer.printf("%-27s %3s %12s\n", "---------", "--------", "----");
			for( PARTS part : parts ) {
				writer.printf("%-30s %3d", part.name(), item_qtys.get(i));
				writer.printf("%15.2f\n", item_costs.get(stage).get(i));
				total += item_costs.get(stage).get(i);
				i++;
			}
			writer.printf("%43s", "Total: ");
			writer.printf("%.2f\n", total);
			writer.println("==================================================");

			i = 0;
			stage++;
			total = 0.0;

			writer.printf("%30s\n","BOARD QUANTITY: 26 to 50");
			writer.printf("%-27s %3s %12s\n", "Component", "Quantity", "Cost");
			writer.printf("%-27s %3s %12s\n", "---------", "--------", "----");
			for( PARTS part : parts ) {
				writer.printf("%-30s %3d", part.name(), item_qtys.get(i));
				writer.printf("%15.2f\n", item_costs.get(stage).get(i));
				total += item_costs.get(stage).get(i);
				i++;
			}
			writer.printf("%43s", "Total: ");
			writer.printf("%.2f\n", total);
			writer.println("==================================================");

			i = 0;
			stage++;
			total = 0.0;

			writer.printf("%30s\n","BOARD QUANTITY: 51 to 100");
			writer.printf("%-27s %3s %12s\n", "Component", "Quantity", "Cost");
			writer.printf("%-27s %3s %12s\n", "---------", "--------", "----");
			for( PARTS part : parts ) {
				writer.printf("%-30s %3d", part.name(), item_qtys.get(i));
				writer.printf("%15.2f\n", item_costs.get(stage).get(i));
				total += item_costs.get(stage).get(i);
				i++;
			}
			writer.printf("%43s", "Total: ");
			writer.printf("%.2f\n", total);
			writer.println("==================================================");

			
			

			writer.close();
		} catch (IOException e) {
			System.out.println("ERROR OUTPUTTING TO FILE. TERMINAING PROGRAM...");
			System.out.println("error code: 2");
			System.exit(1);
		}


		return true;
	}

	public static double truncateDouble( double number, int num_digits ) {
		double result = number;
		String arg = "" + number;
		int index = arg.indexOf('.');
		if( index != -1 ) {
			if( arg.length() > index+num_digits ) {
				arg = arg.substring(0, index+num_digits+1);
				result = Double.parseDouble(arg);
			}
		}
		return result;
	}

	public static void main( String[] args ) {

		String inputfilename = "input.txt";
		String outputfilename = "results.txt";

		//read input file and parse quantities into array
		ArrayList<Integer> item_qtys = read_item_qtys(inputfilename);

		//debug prints
		// for (PARTS p : PARTS.values())
  //          System.out.printf("The quantity of %s is %d%n",
  //                            p, item_qtys.get(p.getNumVal()-1));


		//calculate item costs from item quantities
		//full brunt of the work is done here. need equations to complete
		ArrayList< ArrayList<Double> > item_costs = new ArrayList< ArrayList<Double> >();
		for( int i = 0; i < STAGE; i++ ) {
			//initialize and fill in next stage array
			item_costs.add( calculate_item_costs(i, item_qtys) );

			// for( int j = 0; j < item_costs.get(i).size(); j++ ) {
			// 	System.out.print(item_costs.get(i).get(j) + " " );
			// }
			// System.out.println();
		}

		if( print_to_file(outputfilename, item_qtys, item_costs) ) {
			System.out.println("Generating costs to " + outputfilename + " sucessful.");
		} else {
			System.out.println("Failed to generate costs to " + outputfilename + ".");
			System.exit(1);
		}

	}
}















