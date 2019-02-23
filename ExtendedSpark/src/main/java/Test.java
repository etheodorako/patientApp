import java.io.IOException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import madgik.mySpark.ExaremeSparkSession;
import madgik.mySpark.parser.exception.VtExtensionParserException;

public class Test {

	public static void main(String[] args) throws VtExtensionParserException, IOException, InterruptedException {
		
		
		ExaremeSparkSession e =   ExaremeSparkSession.exaremebuild()
													 .master("local[*]")
													 .appName("Exareme")
													 .getOrCreateExareme();
		
		Dataset<Row> rd2 = e.sqlExtended("select * from exaremple('/home/tim/Desktop/WholoExa/*')").toDF();
		rd2.show(100);

		
		long startTime = System.currentTimeMillis();
		
		
//		Dataset<Row> rd1 = e.sqlExtended("select count(*) from teleia('/home/ethimis/Downloads/example.txt','10','2')").toDF();
//		rd1.show();
		
//		rd1.except(rd2).show();
		
//		e.sqlExtended("SELECT * FROM FOO(',','/home/ethimis/Desktop/people.txt')").show();
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		System.out.println(totalTime + "ms");
	}

}
