﻿import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

class MemoManager {	//	메모 관리 메뉴
	public static void domanagememo(Vector v) {
		 while (true) {
	          System.out.println("\n===<Memo List>===");

	          if (v.size() == 0) {
	             System.out.println("-저장된 메모 없음-");
	          }

	          for (int i = 0; i < v.size(); i++) {
	        	  Object obj = v.get(i);
	        	  String str = (String)obj;
	        	  System.out.print((i+1));
	        	  System.out.println(": " + str);
	          }
	          
	          System.out.println("=================");
	          System.out.println("==<메모 관리 메뉴>==");
	          System.out.println("1.메모 생성");
	          System.out.println("2.메모 업데이트");
	          System.out.println("3.메모 삭제");
	          System.out.println("4.뒤로가기");
	          System.out.println("==============");
	          System.out.print("입력: ");

	          Scanner sc = new Scanner(System.in);
	          int selection = sc.nextInt();

	          if (selection == 1) {
	        	  addmemo(v);
	          }

	          else if (selection == 2) {
	        	  updatememo(v);
	          }

	          else if (selection == 3) {
	        	  deletememo(v);
	          }

	          else if (selection == 4) {
	        	  System.out.println("메인화면으로 돌아갑니다.");
	        	  break;
	          }

	          else {
	          System.out.println("다시 입력하세요.");
	          }
		 }//while
	}

	public static void addmemo(Vector v) {	// 메모 생성
		 System.out.println("추가할 메모내용을 입력하세요.");
         System.out.print("입력: ");
		 Scanner sc1 = new Scanner(System.in);
         String memo = sc1.nextLine();
         v.add(memo);
	}

	public static void updatememo(Vector v) {	//	메모 업데이트
		int number;

		while(true) {
			if (v.size() == 0) {
				 System.out.println("저장된 메모가 없어 메모 수정 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
				 break;
			 }

			System.out.println("수정할 메모 번호를 입력하세요.");
			System.out.print("입력: ");
			Scanner sc2 = new Scanner(System.in);
			number = sc2.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("수정할 해당 메모가 없습니다.\n<MemoList>에 있는 메모번호를 입력하세요.");
			}

			else {
				Object obj = v.get(number-1);
				String str = (String)obj;
				System.out.print(number);
				System.out.println(": " + str);
				v.remove(number-1);
				System.out.println("원하는 내용으로 메모를 수정하세요.");
				System.out.print("입력: ");
				Scanner sc2_1 = new Scanner(System.in);
				String memo = sc2_1.nextLine();
				v.add(number-1, memo);
				break;
			}
		}
	}

	public static void deletememo(Vector v) {	// 메모 삭제
		int number;
		String YesOrNo;
		
		while (true) {
			if (v.size() == 0) {
				System.out.println("저장된 메모가 없어  메모 삭제 기능을 수행할 수 없습니다.\n메모관리 메뉴화면으로 돌아갑니다.");
 				break;
 			}

			System.out.println("삭제를 원하는 해당 메모의 번호를 입력하세요.");
			Scanner sc3 = new Scanner(System.in);
			number = sc3.nextInt();

			if (number > v.size() || number == 0 || number < 0) {
				System.out.println("해당 메모가 없습니다. 유효한 메모 번호 다시 입력하세요.");
				//break;//
			}

			else {
				while (true) {
					Object obj = v.get(number-1);
					String str = (String)obj;
					System.out.print(number);
					System.out.println(": " + str);
					
					System.out.print("정말 해당 메모를 삭제하시겠습니까?(Y/N): ");
					Scanner sc4 = new Scanner(System.in);
					YesOrNo = sc4.nextLine();
					if (true == !(YesOrNo.equals("Y") || YesOrNo.equals("y") || YesOrNo.equals("N") || YesOrNo.equals("n")))
						System.out.println("'Y' 또는'N'으로 제대로 다시 입력하세요.");
					else
						break;
				}

				if (YesOrNo.equals("Y") || YesOrNo.equals("y")) {
					v.remove(number-1);
					System.out.println("해당 메모를 삭제하였습니다.");
					System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
				}

				else if (YesOrNo.equals("N") || YesOrNo.equals("n")) {
					System.out.println("해당 메모를 삭제하지 않았습니다.");
					System.out.println("메모관리 메뉴화면으로 돌아갑니다.");
				}
				
				break;
				}
			}//while
		}
	}

class calculator{	// 계산기 메뉴
	static Scanner scan = new Scanner (System.in);
	calculator() {
		int input;
		do {
			System.out.println("\n=<계산기 메뉴>=");
			System.out.println(" 1.계산");
			System.out.println(" 2.단위변환");
			System.out.println(" 3.뒤로가기");
			System.out.println("===========");
			System.out.print("입력 : ");

			input = scan.nextInt();
			while(input>3||input<0) {
				System.out.println("다시 입력하세요. : ");
				input=scan.nextInt();
			}
			if(input==1)
				calculate();
			else if(input==2)
				convert();
			else {
				System.out.println("메인화면으로 돌아갑니다.\n");
				break;
			}
		}while(true);
	}

	public static void calculate() {	//	계산
		double num1,num2,result=0;
		String operator;
		String answer;
		boolean run = true;
		
		do {
		System.out.print("\n숫자1 : ");
		num1 = scan.nextDouble();
		scan.nextLine();
		System.out.print("숫자2 : ");
		num2 = scan.nextDouble();
		scan.nextLine();
		System.out.print("연산자(+,-,*,/) : ");
		operator=scan.nextLine();

		if(operator.equals("+"))
			result = Add(num1,num2);
		else if(operator.equals("-"))
			result = Sub(num1,num2);
		else if(operator.equals("*"))
			result = Mul(num1,num2);
		else if(operator.equals("/"))
			result = Div(num1,num2);
			

		System.out.println("연산결과 : "+result);
		System.out.print("다시 하시겠습니까? (Y/N) : ");
		answer = scan.nextLine();
		run = YesNo(answer);
		}while(run);
	}
	
	public static double Add(double num1,double num2) {
		return num1+num2;
	}
	public static double Sub(double num1,double num2) {
		return num1-num2;
	}
	public static double Mul(double num1,double num2) {
		return num1*num2;
	}
	public static double Div(double num1,double num2) {
		return num1/num2;
	}
	

	public static void convert() {	// 단위변환
		int menu;
		boolean run = true;
		boolean run1=true;
		double input;
		double result;
		String answer;
		
		do {
			run=true;
			System.out.println("\n==<단위변환 메뉴>==");
			System.out.println(" 1. pound->kg");
			System.out.println(" 2. kg->pound");
			System.out.println(" 3. inch->cm");
			System.out.println(" 4. cm->inch");
			System.out.println(" 5. °F->°C");
			System.out.println(" 6. °C->°F");
			System.out.println(" 7. 뒤로가기");
			System.out.println("===============");
			System.out.print("입력: ");
			menu = scan.nextInt();
			scan.nextLine();

			while(menu>7||menu<1) {
				System.out.print("다시 입력하세요. : ");
				menu = scan.nextInt();
				scan.nextLine();
			}	

			switch(menu) {
			case 1:
				while(run) {
					System.out.print("\n입력(pound) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = pound2kg(input);
					System.out.println("변환 결과(kg) : "+result);
				
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
				
			case 2:
				while(run) {
					System.out.print("\n입력(kg) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = kg2pound(input);
					System.out.println("변환 결과(pound) : "+result);
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
			case 3:
				while(run) {
					System.out.print("\n입력(inch) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = inch2cm(input);
					System.out.println("변환 결과(cm) : "+result);
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
			case 4:
				while(run) {
					System.out.print("\n입력(cm) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = cm2inch(input);
					System.out.println("변환 결과(inch) : "+result);
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
			case 5:
				while(run) {
					System.out.print("\n입력(°F) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = Fahrenheit2Celsius(input);
					System.out.println("변환 결과(°C) : "+result);
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
			case 6:
				while(run) {
					System.out.print("\n입력(°C) : ");
					input = scan.nextDouble();
					scan.nextLine();
					result = Celsius2Fahrenheit(input);
					System.out.println("변환 결과(°F) : "+result);
					System.out.print("다시 하시겠습니까? (Y/N) : ");
					answer = scan.nextLine();
					run = YesNo(answer);
				}
				break;
			case 7:
				run1=false;
				break;
			}
		}while(run1);
	}
	
	public static boolean YesNo(String answer) {
		while(!(answer.equals("n")||answer.equals("N")||answer.equals("y")||answer.equals("Y"))) {
			System.out.print("다시 입력하세요 : ");
			answer = scan.nextLine();
		}
		if(answer.equals("n")||answer.equals("N"))
			return false;
		else
			return true;
		
	}

	
	public static double pound2kg(double input) {
		double result;
		result = input*0.453592;
		return result;
	}

	public static double kg2pound(double input) {
		double result;
		result = input*2.20462;
		return result;	
	}

	public static double inch2cm(double input) {
		double result;
		result = input*2.54;
		return result;	
	}

	public static double cm2inch(double input) {
		double result;
		result = input*0.393701;
		return result;
	}

	public static double Fahrenheit2Celsius(double input) {
		double result;
		result = (input-32)/1.8;
		return result;
	}

	public static double Celsius2Fahrenheit(double input) {
		double result;
		result = input*1.8+32;
		return result;
	}
}


class item implements Serializable{
	int day;
	String name;
	int price;

	public item(int day, String name, int price){
		this.day = day;
		this.name = name;
		this.price = price;
	}

	public item() {}

	public void setday(int day){
		this.day = day;
	}
	public void setname(String name){
		this.name = name;
	}
	public void setprice(int price){
		this.price = price;
	}
	public int getday(){
		return this.day;
	}
	public String getname(){
		return this.name;
	}
	public int getprice(){
		return this.price;
	}
}

class Accountbook { // 가계부 관리 메뉴
	public static int i=0;
	public static void mainaccount(Vector<item> v)throws Exception{
			
		Scanner scan = new Scanner(System.in);
		int number=1;
		while(number!=4){
			System.out.println("========= <Purchase List> ========");
			System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
			for(int i=0;i<v.size();i++){
				System.out.printf("[%d]%10d%10s%10d\n"
						,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());	
			}
			System.out.println("=================================\n");
			System.out.println("========== <가계부 관리 메뉴> ==========");
			System.out.println("1. 가계부 작성\n2. 가계부 업데이트\n3. 구입 내역 삭제\n4. 뒤로가기");
			System.out.println("=================================\n");
			System.out.print("메뉴 번호 입력: ");
			number = scan.nextInt();
			
			switch(number){
			case 1:
				Accountbook.addaccount(v);
				break;
			case 2:	
				Accountbook.updateaccount(v);
				break;
			case 3:
				Accountbook.deleteaccount(v);	
				break;
			case 4:
				return;//뒤로가기
			default:
				System.out.println("1-4 사이에서 입력해주세요");
				break;
				}
		}
	}

	public static void deleteaccount(Vector<item> v) throws IOException { // 구입 내역 삭제
		Scanner scan = new Scanner(System.in);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountbook"));
		if(v.size()==0){
            	System.out.println("삭제할 품목이 없습니다.");
            	return;
		}
		System.out.print("삭제할 구입내역의 번호를 입력하세요. ");
		int num;
		do{
			num = scan.nextInt()-1;
			if(num<0 || num >v.size()-1)
            		System.out.println("번호를 다시 입력하세요.");
		}while(num<0 || num >v.size()-1);
		System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
		System.out.printf("[%d]%10d%10s%10d\n"
				,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());	
		System.out.println("정말 삭제하시겠습니까?(Y/N)");
		String ans = scan.next();
		while(true){
			if(ans.equals("Y")||ans.equals("y")||ans.equals("N")||ans.equals("n")){
				if(ans.equals("Y")||ans.equals("y")){
					v.remove(num);
					break;
				}else if(ans.equals("N")||ans.equals("n")) return;
			}
			System.out.print("다시 입력하세요.(Y/N)");
			ans = scan.next();
		}
		oos.writeObject(v);
		oos.close();
	}
	
	public static void updateaccount(Vector<item> v) throws IOException{	// 가계부 업데이트
		Scanner scan = new Scanner(System.in);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountbook"));
		if(v.size()==0){
            System.out.println("수정할 품목이 없습니다. ");
            return;
		}
		System.out.println("수정할 구입내역의 번호를 입력하세요. ");
		 
		int num;
		do{
			num = scan.nextInt()-1;
			if(num<0 || num >v.size()-1)
            	System.out.println("번호를 다시 입력하세요.");
		}while(num<0 || num >v.size()-1);
		
		System.out.println("번호\t구입날짜 \t상품명\t상품가격   ");
		System.out.printf("[%d]%10d%10s%10d\n"
				,i+1,v.get(i).getday(),v.get(i).getname(),v.get(i).getprice());	
		System.out.println("수정할 항목의 번호를 입력하세요.");
		System.out.println("1.구입날짜\n2.상품명\n3.상품가격");
		
		int cas;
		do{
			cas=scan.nextInt();
			v= update(v,num,cas);
			
		}while(cas<1||cas>3);
		oos.writeObject(v);
		oos.close();
		return;
	}
	
	public static Vector<item> update(Vector<item> v,int num,int cas){
		Scanner scan = new Scanner(System.in);
		int day, price;
		String name;
		if(cas==1){
			System.out.println("구입날짜:");
			day = scan.nextInt();
			v.get(num).setday(day);
		}else if(cas==2){
			System.out.println("상품명:");
			name = scan.next();
			v.get(num).setname(name);
		}else if (cas==3){
			System.out.println("상품가격:");
			price = scan.nextInt();
			v.get(num).setprice(price);
		}else{
			System.out.println("1번~3번 사이에서 입력해주세요.");
		}
		return v;
		
	}
		
	
	public static void addaccount(Vector<item> v) throws IOException{	// 가계부 작성
		Scanner scan = new Scanner(System.in);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accountbook"));
		System.out.print("구입내역의 정보를 입력하세요. ");
		int day, price;
		String name;
		System.out.print("구입날짜:" );
		day = scan.nextInt();
		System.out.print("상품명:" );
		name = scan.next();
		System.out.print("상품가격:" );
		price = scan.nextInt();
		v = adding(v,day,name,price);
		oos.writeObject(v);
		oos.close();
		return;
	}
	public static Vector<item> adding(Vector<item> v,int day,String name,int price){
		item i1 = new item(day,name,price);
		v.add(i1);
		return v;
	}
}
public class MainProgram {	//	메인 메뉴

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner (System.in);
		Vector v = new Vector();
		Vector<item> v2 = new Vector<item>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accountbook"));
		Object s2;
		if (ois.read()!=-1)
			 s2 = ois.readObject();
		v2 = (Vector<item>)ois.readObject();
		while (true) {
		System.out.printf("========= MENU =========%n"
				+ "1. Memo manager (메모관리)%n"
				+ "2. Calculator (계산기)%n"
				+ "3. Account book (가계부)%n"
				+ "4. Exit (종료)%n"
				+ "========================%n");
		System.out.printf("메뉴 번호 입력: ");
		int sel = scan.nextInt();	// 번호 입력
		if (sel==1) {
			MemoManager.domanagememo(v);
			}// 메모관리 메뉴 호출
		else if (sel==2){
			new calculator();
			}// 계산기 메뉴 호출
		else if (sel==3){
			Accountbook.mainaccount(v2);
            }// 가계부 메뉴 호출
		else if (sel==4) { // 종료
			break;
			}
		else {
			System.out.println("다시 입력하세요. ");
			}
		}
		}
	}

