import java.io.IOException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import madgik.mySpark.ExaremeSparkSession;
import madgik.mySpark.parser.exception.VtExtensionParserException;

public class Test {

	public static void main(String[] args) throws VtExtensionParserException, IOException, InterruptedException {
		
//		String s = "abcd";
//		System.out.println(java.util.Arrays.toString(s.split("(?<=\\G.{2})")));
		
		ExaremeSparkSession e =   ExaremeSparkSession.exaremebuild()
//													 .master("spark://neopas:7077")
													 .master("local[*]")
													 .appName("Exareme")
													 .config("spark.deploy.defaultCores", 4)
													 .config("spark.executor.cores", 4)
													 .config("SPARK_WORKER_CORES", 4)
													 .config("spark.jars", "target/ExtendedSpark-0.0.1-SNAPSHOT.jar")
													 .getOrCreateExareme();
		
		long startTime = System.currentTimeMillis();
		
		
//		Dataset<Row> rd1 = e.sqlExtended("select count(*) from teleia('/home/ethimis/Downloads/example.txt','10','2')").toDF();
//		rd1.show();
		
		Dataset<Row> rd2 = e.sqlExtended("select * from equallengthhammingdistanceone('/home/ethimis/Downloads/example.txt','10','5')").toDF();
		rd2.show(100);
//		rd1.except(rd2).show();
		
//		e.sqlExtended("SELECT * FROM FOO(',','/home/ethimis/Desktop/people.txt')").show();
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println(totalTime + "ms");
	}

}
