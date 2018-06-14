package readText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class read {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String fileName = null;
		
		if(args.length == 0) {
			fileName = "C:\\d.txt"; //C드라이브 밑에 d.txt 불러오기
		} else {
			fileName = "C:\\" + args; //C드라이브 밑에 인자값으로 준 텍스트 파일 불러오기
		}
		
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
		
		if(s != null) {
			System.out.println("문자 삭제 후 : " + s); // 위의 6개 문자 삭제 후 출력
		}
		
		String[] ss = s.split(" "); // 띄어쓰기 기준으로 문자 자르기
		
		File file = new File("C:\\sample.txt");
		FileWriter fileWrite = new FileWriter(file, true);
		
		String line = System.getProperty("line.separator");
		
		fileWrite.write("Word        Length" + line);
		System.out.println("Word        Length");
		
		
		for(int i = 0 ; i < ss.length ; i++) {
			System.out.println(ss[i] + "        " + ss[i].length() );
			fileWrite.write(ss[i] + "        " + ss[i].length() + line);
		}
		
		System.out.println("파일 생성완료");
		
		fileWrite.flush();
		fileWrite.close();
		
	}

}
