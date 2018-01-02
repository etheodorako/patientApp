import java.io.IOException;
import java.util.Arrays;

import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.linalg.Matrix;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.stat.Statistics;

import madgik.mySpark.ExaremeSparkSession;
import madgik.mySpark.parser.exception.VtExtensionParserException;


public class Correlation {

	public static void main(String[] args) throws VtExtensionParserException, IOException, InterruptedException {
		ExaremeSparkSession e =   ExaremeSparkSession.exaremebuild()
	//			 .master("spark://neopas:7077")
				 .master("local[*]")
				 .appName("Exareme")
				 .getOrCreateExareme();
		
		JavaSparkContext jsc = new JavaSparkContext(e.getSparkSession().sparkContext());
		
		JavaDoubleRDD seriesX = jsc.parallelizeDoubles(
		Arrays.asList(1.0, 3.0, 3.0, 4.0, -7.0));  // a series
	
		// must have the same number of partitions and cardinality as seriesX
		JavaDoubleRDD seriesY = jsc.parallelizeDoubles(
		Arrays.asList(1.0, 3.0, 3.0, 5.0, 6.0));
	
		// compute the correlation using Pearson's method. Enter "spearman" for Spearman's method.
		// If a method is not specified, Pearson's method will be used by default.
		Double correlation = Statistics.corr(seriesX.srdd(), seriesY.srdd(), "pearson");
		System.out.println("Correlation is: " + correlation);
		
	
		// note that each Vector is a row and not a column
//		JavaRDD<Vector> data = jsc.parallelize(
//		  Arrays.asList(
//		    Vectors.dense(1.0, 10.0, 100.0),
//		    Vectors.dense(2.0, 20.0, 200.0),
//		    Vectors.dense(5.0, 33.0, 366.0)
//		  )
//		);
//	
//		// calculate the correlation matrix using Pearson's method.
//		// Use "spearman" for Spearman's method.
//		// If a method is not specified, Pearson's method will be used by default.
//		Matrix correlMatrix = Statistics.corr(data.rdd(), "pearson");
//		System.out.println(correlMatrix.toString());
	}
	
}
