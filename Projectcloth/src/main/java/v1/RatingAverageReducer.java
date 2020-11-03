package v1;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RatingAverageReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		//Cloth_ID key와 rating value를 받아서 cloth_id별 평균을 구해야함
		
		//최댓값 초기 가장작은 값 선언
		int AverageRating = 0;
		int SUMRating = 0;
		int Count =0;
		for (IntWritable value : values) {
			
			 SUMRating += value.get();
			 Count ++;
		}
		
		AverageRating = SUMRating/Count;
		context.write(key, new IntWritable(AverageRating));
		
	}

}
