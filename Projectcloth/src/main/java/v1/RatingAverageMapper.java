package v1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class RatingAverageMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	

	//mapper class는  map함수를 통해 입력데이터의 longwritable의 오프셋, text는 한행의내용!
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		//clothing ID 별 Rating을 구해야함
		String line = value.toString();	
		String Cloth_ID = "";
		int Rating=0;
		
		//옷 상품 아이디 자리 수에 따라 경우의 수
		if (line.indexOf(",") == 1){
			//나이가 한 자리인경우 
			Cloth_ID = line.substring(0,1);
			if(line.indexOf(",",2) == 3)
			{
				Rating = Integer.parseInt(line.substring(4,5));
			}
			//나이가 두 자리인 경우
			else if(line.indexOf(",",2) == 4)
			{
				Rating = Integer.parseInt(line.substring(5,6));
			}
		
	    }
		if (line.indexOf(",") == 2){
			
			Cloth_ID = line.substring(0,2);
			
			if(line.indexOf(",",3) == 4)
			{
				Rating = Integer.parseInt(line.substring(5,6));
			}
			//나이가 두 자리인 경우
			else if(line.indexOf(",",3) == 5)
			{
				Rating = Integer.parseInt(line.substring(6,7));
			}
	    }
		if (line.indexOf(",") == 3){
			Cloth_ID = line.substring(0,3);
			if(line.indexOf(",",4) == 5)
			{
				Rating = Integer.parseInt(line.substring(6,7));

			}
			//나이가 두 자리인 경우
			else if(line.indexOf(",",4) == 6)
			{
				Rating = Integer.parseInt(line.substring(7,8));

			}
	    }
		if (line.indexOf(",") == 4){
			Cloth_ID = line.substring(0,4);
			if(line.indexOf(",",5) == 6)
			{
				Rating = Integer.parseInt(line.substring(7,8));

			}
			//나이가 두 자리인 경우
			else if(line.indexOf(",",6) == 7)
			{
				Rating = Integer.parseInt(line.substring(8,9));
			}
	    }
		context.write(new Text(Cloth_ID),new IntWritable(Rating));
	}
}
