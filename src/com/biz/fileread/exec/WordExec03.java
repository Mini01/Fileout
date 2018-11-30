package com.biz.fileread.exec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.fileread.vo.WordVO;

public class WordExec03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String readFile = "D:/bizwork/workspace/ExFiles/영단어.txt";
		
		List<WordVO> wordList = new ArrayList();
		
		// Text파일을 읽기위한  객체
		FileReader fr;
		// Text파일을 문자열단위로 변환해서 읽기 위한 객체
		BufferedReader buffer;
		
		try {
			fr = new FileReader(readFile);
			buffer = new BufferedReader(fr);
			
			while(true) {
				// 한라인씩 문자열로 읽기
				String strWord = buffer.readLine();
				
				// strWord가 null 이면 buffer에 더이상 읽을 내용이 없으면
				if(strWord == null) break;
				
				// strWord가 null 아닌경우 계속...
				
				// strWord에 담긴 문자열을 :을 기준으로 분해해서 영단어와 한글풀이를 분해하라
				String[] strWords = strWord.split(":");
				
				// WordVO를 선언 생성해서
				// WordVO는 단어 한개의 영단어와 한글풀이를 담을 바구니 클래스다
				WordVO vo = new WordVO();
				// 영단어와 한글풀이를 변수에 SETTING
				vo.setStrEng(strWords[0]);
				vo.setStrKor(strWords[1]);
				
				// 단어바구니를 단어 리스트에 추가
				wordList.add(vo);
				
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try end
		
		// ?? 여기에서 사용(접근)할 수 있는 변수는?
        // wordList , readFile 사용가능
		
		// 단어장이 wordList에 만들어진 상태
		// wordList를 사용해서 단어게임을 만들어본다.
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			// wordList를 뒤섞어서 같은 단어가 나오지 않도록 wordList를 뒤 섞기
			Collections.shuffle(wordList);
			
			// 이중에서 0번 위치의 단어 1개를 추출 
			WordVO vo = wordList.get(0);
			
			// 임의 위치에서 1개의 단어를 추출
			// 1. wordList가 몇개인가?
			int wordCount = wordList.size();
			
			// 2. 0 부터 wordCount - 1까지 중 임의의숫자 1개를 생성
			int intIndex = (int)(Math.random()* wordCount);
			// 3. 생성된 intIndex 위치의 단어 1개를 추출
			vo = wordList.get(intIndex);
			
			System.out.println("다음 풀이에 맞는 영단어를 입력하세요");
			System.out.println(vo.getStrKor());
			System.out.print("단어(종료하려면 --END)>>");
			
			// scanner처럼 장치와 관련된 클래스는 한 코드에서 
			// 여러번 다시 생성하는것이 좋지 않다.
			// Scanner scanner = new Scanner(System.in);  
			// >> while문이 시작되기전으로 이동한다 while문안에서는 scanner를 계속 재 활용한다 
			String inputEng = scanner.nextLine();
			if(inputEng.equals("--END")) {
				break;
			}
			if(inputEng.equalsIgnoreCase(vo.getStrEng())) {
				System.out.println("참 잘했어요!!!");
			}else {
				System.out.println("좀더 생각해 보시지!!!");
				System.out.println(vo.getStrEng());
			}
			System.out.println("=============================");
			
			
		}
		System.out.println("GAME OVER !!!");
		/*
		 *  맞은개수가 몇개?
		 *  틀린개수가 몇개?
		 *  
		 *  몇개 이상 틀리면 강제 종료
		 */
		
		
	}

}
