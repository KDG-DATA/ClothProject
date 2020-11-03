package v1;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class RatingAverage extends Configured implements Tool{
	
	
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.printf("Usage: %s [generic options] <input> <output> \n", getClass().getSimpleName());
			ToolRunner.printGenericCommandUsage(System.err);
			return -1;
		}
		
		Configuration conf = getConf();
		Job job = Job.getInstance(conf,"RatingAverageCloth");
		job.setJarByClass(getClass());
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job,  new Path(args[1]));
		
		job.setMapperClass(RatingAverageMapper.class);
		job.setReducerClass(RatingAverageReducer.class);
		
		//리듀스 함수의 출력 클래스 지정 
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true) ? 0:1);
		
		
		return job.waitForCompletion(true) ? 0: 1;
	}
	
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new RatingAverage(), args);
		System.exit(exitCode);
	}
	
}
