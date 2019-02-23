package madgik.mySpark.vtFunctions;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import madgik.mySpark.parser.exception.VtExtensionParserCancelationException;

public class Exaremple {

	private String filePath;
	
	public Exaremple(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String mapReduce(SparkSession spark) throws VtExtensionParserCancelationException{
		try{
			
			Dataset<Row> data2 = spark.read().json(filePath);

			// Creates a temporary view using the DataFrame
			data2.createOrReplaceTempView("exa");
			
			return "exa";
		}catch(Exception e){
			throw new VtExtensionParserCancelationException(e.getMessage());
		}
		
	}
	
}
