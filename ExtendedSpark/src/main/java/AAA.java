import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.apache.spark.sql.api.java.UDF1;

public class AAA {

	public static void main(String[] args) {
		
//		ExaremeSparkSession e =   ExaremeSparkSession.exaremebuild()
//				 .master("local[*]")
//				 .appName("Exareme")
//				 .getOrCreateExareme();
//		
//		
//		
//
//		e.getSparkSession().udf().register("toUpper", toUpper, DataTypes.StringType);
		
		
		BufferedReader br = null;
		FileReader fr = null;
		
		BufferedReader br2 = null;
		FileReader fr2 = null;
		
		Random randomGenerator = new Random();

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader("/home/ethimis/Downloads/oposnane/large.init");
			br = new BufferedReader(fr);
			
			fr2 = new FileReader("/home/ethimis/Downloads/oposnane/large2.work");
			br2 = new BufferedReader(fr2);

			String sCurrentLine;
			
			PrintWriter writer = new PrintWriter("/home/ethimis/Downloads/oposnane/large.panta", "UTF-8");
			
//			int count = 1;
//			int cc = 1;
//			while ((sCurrentLine = br.readLine()) != null) {
////				System.out.println(sCurrentLine);
//				writer.println(sCurrentLine);
//				
//				if(count == 10000) {
//					
//					int randomInt = randomGenerator.nextInt(25 - 3 + 1) + 3;
//					String s = "F "+randomInt;
//					System.out.println(s + " | Line: "+cc);
//					writer.println(s);
//					count = 0;
//					cc++;
//				}
//				
//				count++;
//				cc++;
//			}
//			
//			System.out.println(count);
			
			while ((sCurrentLine = br.readLine()) != null) {
				writer.println(sCurrentLine);
			}
			writer.println("S");
			while ((sCurrentLine = br2.readLine()) != null) {
				writer.println(sCurrentLine);
			}
			
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
	}

	private static UDF1<String, String> toUpper = new UDF1<String, String>() {
	    public String call(final String str) throws Exception {
	        return str.toUpperCase();
	    }
	};
	
	
}
