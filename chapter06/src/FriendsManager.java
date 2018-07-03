import java.util.Scanner;

public class FriendsManager {
	static final int MAX=20;
	static String[] nameList = new String[MAX];
	static int[] ageList = new int[MAX];
	static String[] excelList = new String[MAX];
	static String[] emailList = new String[MAX];
	
	static int index = -1;
	static int count = 0;
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("메뉴를 선택하세요.=================");
			System.out.print("(I)nsert, (S)elect, (U)pdate, (D)elete, (Q)uit : ");
			String menu = scan.nextLine().toLowerCase().trim();
			if(menu != null && menu.length() > 0) {
				switch(menu.charAt(0)) {
				case 'i':
					System.out.println("=====데이터를 입력합니다.=====");
					insertFriendInfo();
					printFriendInfo();
					break;
				case 's':
					System.out.println("=====데이터를 조회합니다.=====");
					index = searchFriendInfoByEmail();
					if(index >= 0 && index < count) {
						printFriendInfo();
					}else {
						System.out.println("찾는 데이터가 없습니다.");
					}
					break;
				case 'u':
					System.out.println("=====데이터를 수정합니다.=====");
					index = searchFriendInfoByEmail();
					if(index >= 0 && index < count) {
						updateFriendInfo();
					}else {
						System.out.println("수정하려는 데이터가 없습니다.");
					}
					break;
				case 'd':
					System.out.println("=====데이터를 삭제합니다.=====");
					index = searchFriendInfoByEmail();
					if(index >= 0 && index < count) {
						deleteFriendInfo();
					}else {
						System.out.println("삭제하려는 데이터가 없습니다.");
					}
					break;
				case 'q':
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default :
					System.out.println("잘 못된 메뉴입니다.");
					break;
				}
			}else {
				System.out.println("*********메뉴를 입력하세요.**********");
			}
			
		}//end while
	}//end main

	private static void deleteFriendInfo() {
		for(int i=index; i<count; i++) {
			nameList[i] = nameList[i+1];
			ageList[i] = ageList[i+1];
			excelList[i] = excelList[i+1];
			emailList[i] = emailList[i+1];
		}
		count--;
	}

	private static void updateFriendInfo() {
		System.out.printf("이름(%s):", nameList[index]);
		String name = scan.nextLine().trim();
		if(name.length()>0) {
			nameList[index] = name;
		}
		System.out.printf("나이(%s):", ageList[index]);
		String str = scan.nextLine().trim();
		if(str.length()>0) {
			ageList[index] = Integer.parseInt(str);
		}
		
		System.out.printf("장점(%s):", excelList[index]);
		String excel = scan.nextLine().trim();
		if(excel.length()>0) {
			excelList[index] = excel;
		}
		System.out.printf("이메일(%s):", emailList[index]);
		String email = scan.nextLine().trim();
		if(email.length()>0) {
			emailList[index] = email;
		}
	}

	private static int searchFriendInfoByEmail() {
		System.out.print("이메일 주소를 입력하세요.");
		String email = scan.nextLine();
		for(int i=0; i<count; i++) {
			if(	emailList[i].equals(email) ) {
				return i;
			}
		}
		return -1;
	}

	private static void insertFriendInfo() {
		System.out.print("이름:"); nameList[count] = scan.nextLine().trim();
		System.out.print("나이:"); ageList[count] = Integer.parseInt(scan.nextLine().trim());
		System.out.print("장점:"); excelList[count] = scan.nextLine().trim();
		System.out.print("이메일:"); emailList[count] = scan.nextLine().trim();
		index = count;
		count++;
	}
	
	private static void printFriendInfo() {
		System.out.printf("이름:%s, 나이:%d, 이메일:%s, 장점:%s\n", 
				nameList[index], ageList[index], emailList[index], excelList[index]);
	}

}//end class

