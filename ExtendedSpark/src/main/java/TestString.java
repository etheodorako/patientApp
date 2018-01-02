import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.catalyst.expressions.Explode;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import madgik.mySpark.ExaremeSparkSession;
import scala.Function1;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.JavaConversions;
import scala.collection.Seq;
import scala.collection.mutable.WrappedArray;
import scala.runtime.BoxedUnit;

public class TestString {

	public static void main(String[] args) {
		
		ExaremeSparkSession e =   ExaremeSparkSession.exaremebuild()
//				 .master("spark://neopas:7077")
				 .master("local[*]")
				 .appName("Exareme")
				 .getOrCreateExareme();
		
		Dataset<Row> data2 = e.getSparkSession().read().json("/home/tim/Desktop/WholoExa/*");
		
		Dataset<Row> flattenData =  data2.select(data2.col("filename"),org.apache.spark.sql.functions.explode(data2.col("data")).as("flattendata"));
		
		JavaRDD<Row> jrdd = flattenData.toJavaRDD();
		
		String schemaString = "filename x y z";
		
		// Generate the schema based on the string of schema
		List<StructField> fields = new ArrayList<StructField>();
		for (String fieldName : schemaString.split(" ")) {
			
			if(fieldName.equals("filename")){
				StructField field = DataTypes.createStructField(fieldName, DataTypes.StringType, true);
				fields.add(field);
			}else{
				StructField field = DataTypes.createStructField(fieldName, DataTypes.DoubleType, true);
				fields.add(field);
			}
		}
		StructType schema = DataTypes.createStructType(fields);
		
		JavaRDD<Row> rowRDD = jrdd.map( x -> {
			
			
			List<String> dimensions = new ArrayList<String>();
			
			dimensions.addAll(JavaConversions.seqAsJavaList((Seq<String>) x.getList(1).get(0)));
			
			dimensions.add(0, (String) x.get(0));
			
			return RowFactory.create(dimensions.toArray());
			
		});
		
		Dataset<Row> dimensionsDataFrame = e.getSparkSession().createDataFrame(rowRDD, schema).cache();
		
		dimensionsDataFrame.show();
		
		dimensionsDataFrame.toJavaRDD();
		
//		System.out.println(flattenData.count());
		
		
		
//		
//		flattenData.show(false);
		
//		data.printSchema();
//		
//		data.show();
//		
//		data.select("dancers").show(false);
//		
//		data.select(org.apache.spark.sql.functions.explode(data.col("conn"))).show(false);
//		
//		data.select(org.apache.spark.sql.functions.explode(data.col("labels")).as("Labels")).show(false);
//		
//		
//		data.select("Nf").show();
//		
//		Dataset<Row> flattenData =  data.select(org.apache.spark.sql.functions.explode(data.col("data")).as("flattendata"));
//		
//		flattenData.show(false);
//		
//		JavaRDD<Row> jrdd = flattenData.toJavaRDD();
//		
//		String schemaString = "x y z";
//		
//		// Generate the schema based on the string of schema
//		List<StructField> fields = new ArrayList<StructField>();
//		for (String fieldName : schemaString.split(" ")) {
//		  StructField field = DataTypes.createStructField(fieldName, DataTypes.DoubleType, true);
//		  fields.add(field);
//		}
//		StructType schema = DataTypes.createStructType(fields);
//		
//		JavaRDD<Row> rowRDD = jrdd.map( x -> {
//			
//			List<Double> dimensions = JavaConversions.seqAsJavaList((Seq<Double>) x.getList(0).get(0));
//			
//			return RowFactory.create(dimensions.toArray());
//			
//		});
//		
//		// Apply the schema to the RDD
//		Dataset<Row> dimensionsDataFrame = e.getSparkSession().createDataFrame(rowRDD, schema).cache();
//		Dataset<Row> dimensionsDataFrame2 = e.getSparkSession().createDataFrame(rowRDD, schema).cache();
//		
//		dimensionsDataFrame.show(100);
////		System.out.println(dimensionsDataFrame.count());
//		
////		dimensionsDataFrame2.coalesce(Math.round(dimensionsDataFrame.count()/ 100)).write().format("com.databricks.spark.csv").option("header", "true").save("/home/ethimis/Desktop/Hi");
//		
////		dimensionsDataFrame2.repartition(Math.round(dimensionsDataFrame.count()/ 100)).write().format("com.databricks.spark.csv").option("header", "true").save("/home/ethimis/Desktop/Hi");
//		
//		JavaRDD<Row> inputRdd = dimensionsDataFrame.select("x").repartition(Math.round(dimensionsDataFrame.count()/ 100)).toJavaRDD().mapPartitionsWithIndex((index, iter) -> { 
//			
//			System.out.println("Called in partition: "+index + " with values: ");
//			int count = 0;
//			while(iter.hasNext()){
//				count ++;
//				System.out.println(iter.next());
//			}
//			System.out.println(count);
//			return iter;
//			
//		}, false);
//		
//		inputRdd.collect();
//
//		
//		System.out.println(Math.round(dimensionsDataFrame.count()/ 100));
		
		
	}

}
