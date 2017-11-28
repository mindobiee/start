package accountbook;

import java.util.Scanner;
import java.util.Vector;


class item{
	int day;
	String name;
	int price;

public item(int day, String name, int price){
	this.day = day;
	this.name = name;
	this.price = price;

}	
	
public item() {
	// TODO Auto-generated constructor stub
}

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
/*
public void print(int n){
	System.out.println("   날짜          상품이름         가격");
	for(int j=0;j<n;j++)
		System.out.println(day + "  "+ name + "  " + price);
}*/



public class accountbook {
	
	public static int i=0;
	//private static Object Vector;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number=1;
		Vector<item> v = new Vector<item>();
		while(number!=4){
		//purchaselist[] item= new purchaselist[i];
		System.out.println("========= <Purchase List> ========");
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		for(int i=0;i<v.size();i++){
			System.out.println(" ["+i+"] " + v.get(i).getday()
					+ "\t"+v.get(i).getname()+"\t"+v.get(i).getprice());
		}
		System.out.println("=================================\n");
		System.out.println("========== <가계부 관리 메뉴> ==========\n");           
		System.out.println("1. 가계부 작성\n2. 가계부 업데이트\n3. 구입 내역 삭제\n4. 뒤로가기\n");
		System.out.println("=================================\n");
		System.out.println("메뉴 번호 입력:");
		number = scan.nextInt();
		switch(number){
		case 1:
			addaccount(v);
			break;
		case 2:
			updateaccount(v);
			break;
		case 3:
			deleteaccount(v);
			break;
		case 4:
			return;//뒤로가기
		default:
			System.out.println("1-4 사이에서 입력해주세요");
			break;
		}
		
		}
	}
	private static void deleteaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 구입내역의 번호를 입력하세요. ");
		int num = scan.nextInt();
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"\t"+v.get(num).getname()+"\t"+v.get(num).getprice());
		System.out.println("정말 삭제하시겠습니까?(Y/N)");
		String ans = scan.next();
		if(ans.equals("Y"))
			v.remove(num);
		else
			return;
	}
	private static void updateaccount(Vector<item> v) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 구입내역의 번호를 입력하세요. ");
		int day, price;
		String name;
		int num = scan.nextInt();
		System.out.println("  번호    구입날짜      상품명      상품가격   ");
		System.out.println(" ["+num+"] " + v.get(num).getday()+"  "+v.get(num).getname()+"   "+v.get(num).getprice());
		System.out.println("수정할 항목의 번호를 입력하세요.");
		System.out.println("1.구입날짜\n2.상품명\n3.상품가격");
		int cas = scan.nextInt();
		switch(cas){
		case 1:
			System.out.println("구입날짜:");
			day = scan.nextInt();
			v.get(num).setday(day);
			break;
		case 2:
			System.out.println("상품명:");
			name = scan.next();
			v.get(num).setname(name);
			break;
		case 3:
			System.out.println("상품가격:");
			price = scan.nextInt();
			v.get(num).setprice(price);
		default:
			break;
		}
		return;
		
		
	}
	public static void addaccount(Vector<item> v){
		Scanner scan = new Scanner(System.in);
		System.out.println("구입내역의 정보를 입력하세요.");
		int day, price;
		String name;
		System.out.println("구입날짜:");
		day = scan.nextInt();
		System.out.println("상품명:");
		name = scan.next();
		System.out.println("상품가격:");
		price = scan.nextInt();
		item i1 = new item(day,name,price);
		v.add(i1);
		return;
		

	}

}
