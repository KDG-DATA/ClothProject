package hadoop_book.Projectcloth;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 String t = "4,28,5,1";
    	 String y = "1,7673,32,4,1";
    	 String Cloth_ID = "";
    	 String Cloth_ID1 = "";
    	 int Rating=3;
    	 int k = 10;
    	 int z = 3;
    	 
        int x;
        x = t.indexOf(",",2);
        
        System.out.println(k/z);
	 	 if (t.indexOf(",") == 1){
				//나이가 한 자리인경우 
				Cloth_ID = t.substring(0,1);
	
				if(t.indexOf(",",2) == 3)
				{
					Rating = Integer.parseInt(t.substring(4,5));
					System.out.println(Rating);
				}
				//나이가 두 자리인 경우
				else if(t.indexOf(",",2) == 4)
				{
					Rating = Integer.parseInt(t.substring(5,6));
					System.out.println(Rating);
				}
			
		    }
	 	   
		
		
    }
    }


