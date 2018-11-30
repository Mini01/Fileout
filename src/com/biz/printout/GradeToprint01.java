package com.biz.printout;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.printout.vo.GradeVO;

public class GradeToprint01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// GradeVO(성적정보)를 젖아할 List 객체를 선언, 생성
		// gradeList 개수는 ? : 
        List<GradeVO> gradeList = new ArrayList();
		
        // 성적정보 30개를 생성하는 부분
		for(int i = 0 ; i < 30; i ++) {
			
			// i 변수를 사용해서 학번을 문자열로 생성하는 부분
			// i 변수 값에 1을 더해서 학번 1부터 30까지 만들어지도록
			// 문자열로 변환하기 위해서 ""+
			String strNum = "" + (i+1);
			
			// 임의 난수 50부터 100까지 범위의 임의 난수를 발생해서 각 과목의 점수를 임의로 생성
			int intKor = (int)(Math.random()* (100-50+1)) +50;
			int intEng = (int)(Math.random()* (100-50+1)) +50;
			int intMath = (int)(Math.random()* (100-50+1)) +50;
			
			// 리스트에 성적정보를 추가 하기 위해서 한 학생의 성적정보를 새로 생성
			GradeVO gradeVO = new GradeVO();
			
			// 새로 생성된 학생의 성적 정보에 학번과 과목점수를 setting
			gradeVO.setStrNum(strNum);
			gradeVO.setIntKor(intKor);
			gradeVO.setIntEng(intEng);
			gradeVO.setIntMath(intMath);
			
			// 세팅된 한 학생의 성적정보를 gradeList에 추가
			gradeList.add(gradeVO);
			
			}// for end
		    
		   // 30명 학생의 성적 정보가 담긴 gradeList를 이제 확보완료!!
		
		/*
		 *  위에서 생성된 gradeList를 활용하여
		 *  ../gradeList.txt 파일을 생성하시오
		 *  각 라인의 구성은
		 *  학번 : 국어 점수 : 영어점수 : 수학점수
		 *  형식으로 저장하시오
		 */
		
		String printFile = "D:/bizwork/workspace/ExFiles/gradeList.txt"; // 메모장 생성할 위치에대한 정보를 담고있는변수
		try {
			PrintWriter pw = new PrintWriter(printFile);// 경로지정해서 쓰는 유틸클래스  위치지정,프린트로메모장내용채워넣음
			
			// gradeList에 포함된 vo의 개수만큼 반복
			// 굳이 gradList개수가 30개라고 표헌하지 않고
			// gradeList.size() 메소드를 활용해서 30이라는 값을 연산해서 추출
			for(int i=0; i<gradeList.size(); i++) {  //gardeList를 불러서 값을가져오기
				// gradeList로 부터 vo를 추출
				// gradeList로 부터 i번째 (i: 0~29)
				GradeVO gradeVO = gradeList.get(i); // 변수선언해주고 리스트에서 값가져오기
				
				// 추출된 vo에서 학번과 성적들을 다시 getter
				
				pw.println(gradeVO.getStrNum()+" : "+gradeVO.getIntKor()+" : "+gradeVO.getIntEng()+" : "+gradeVO.getIntMath());	
			}
			pw.close(); //자원해제
			System.out.println("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
		
	

}
