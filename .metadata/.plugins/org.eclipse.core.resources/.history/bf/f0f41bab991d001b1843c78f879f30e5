package hadoop_book.Projectcloth;
import java.io.*;
import java.util.ArrayList;
public class Splitcode {

	public static void main(String[] args) throws Exception {
		//옷 데이터를 읽고 저장하기위한 어레이리스트 선언 스트링으로
	    ArrayList data = new ArrayList<String>();
	    try {
	    	//cloth 옷 데이터  csv파일 읽어오기
	    	File csv = new File("/home/kdg/바탕화면/hadoop-book/sortdata.csv");
	    	BufferedReader br = new BufferedReader(new FileReader(csv));
	    	String line ="";
	    	
	    	while ((line = br.readLine()) !=null) {
	    		String[] token = line.split(",",-1);
	    		for(int i=1;i<token.length;i++) {
	    			//columns=["clothingID","Age","Rating","RecommendID-리뷰어가 상품을 추천 OR NOT"
	    			
	    			data.add(token[i]);
	    		}
	    	}
	    	System.out.print(data);
	    br.close();	
	    }
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	    }
	}
