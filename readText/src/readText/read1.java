package readText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class read1 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub

		String	fileName = "D:\\directory\\d.txt"; //C드라이브 밑에 d.txt 불러오기
		
		BufferedReader in = new BufferedReader(new FileReader(fileName)); //D드라이브 밑에 sample1 메모장 내용 읽기
		String s = in.readLine(); //메모장 내용을 s 변수에 저장
		
		if(s != null) {
			System.out.println("메모장 내용 : " + s);
		}
		
		s = s.replace(".", ""); //. 삭제
		s = s.replace(",", ""); //, 삭제
		s = s.replace("-", ""); //- 삭제
		s = s.replace("ö", ""); //ö 삭제
		s = s.replace("ä", ""); //ä 삭제
		s = s.replace("ü", ""); //ü 삭제
		s = s.replace("(", ""); //( 삭제
		s = s.replace(")", ""); //) 삭제
		s = s.replace(":", ""); //: 삭제
		s = s.replace("'", ""); //' 삭제
		
		
		if(s != null) {
			System.out.println("문자 삭제 후 : " + s); // 위의 6개 문자 삭제 후 출력
		}
		
		String[] ss = s.split(" "); // 띄어쓰기 기준으로 문자 자르기
		
		/*File file = new File("D:\\d_sample.txt"); //파일 저장 경로
		FileWriter fileWrite = new FileWriter(file, false);
		*/
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\directory\\d_sample.txt"), "UTF-8"));
		
		String line = System.getProperty("line.separator"); //한줄 띄기 구분자
		
		writer.write("Wort        Laenge"); // 맨 첫줄 추가
		System.out.println("Wort        Laenge");
		writer.newLine();
		
		
		for(int i = 0 ; i < ss.length ; i++) { // 단어 수만큼 잘라서 출력
			System.out.println(ss[i] + "        " + ss[i].length() );
			writer.write( ss[i].length()+ "        " + ss[i]);
			writer.newLine();
		}
		
		System.out.println("파일 생성완료");
		
		writer.flush();
		writer.close();
		
	}
}
