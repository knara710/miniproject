import java.util.Scanner;

public class NameCardManager {

	static final int MAX = 100;
	static String[] nameList = new String[MAX];
	static String[] officeNameList = new String[MAX];
	static String[] jobList = new String[MAX];
	static String[] phoneList = new String[MAX];
	static String[] officePhoneList = new String[MAX];
	static String[] emailList = new String[MAX];
	
	//배열을 사용할 때에는 항상 따라다니는 변수 두 개를 선언해 주세요.
	static int index = -1;
	static int count = 0;
	
	//스캐너
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//메뉴 처리
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (S)elect, (U)pdate, (D)elete, (Q)uit");
			String menu = scan.nextLine();
//			menu = menu.toLowerCase();
//			switch(menu.charAt(0)) {
			switch(menu.toLowerCase().charAt(0)) {
			case 'i' :
				System.out.println("명함 정보를 입력합니다.");
				insertNameCardInfo();
				break;
			case 's' :
				System.out.println("명함 정보를 조회합니다.");
				index = searchNameCardByName();
				if(index >= 0 && index <count) {
					printNameCardInfo(index);
				}else {
					System.out.println("조회한 정보가 없습니다.");
				}
				break;
			case 'u' :
				System.out.println("명함 정보를 수정합니다.");
				index = searchNameCardByName();
				if(0 <= index && index < count) {
					updateNameCardInfo(index);
				}else {
					System.out.println("수정할 정보가 없습니다.");
				}
				break;
			case 'd' :
				System.out.println("명함 정보를 삭제합니다.");
				index = searchNameCardByName();
				if( index>=0 && index<count) {
					deleteNameCardInfo(index);
				}else {
					System.out.println("삭제할 정보가 없습니다.");
				}
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("없는 메뉴 입니다.");
				break;
			}
		}//end while
	}//end main
	
	private static void deleteNameCardInfo(int idx) {
		for(int i=idx; i<count-1; i++) {
			nameList[i] = nameList[i+1];
			officeNameList[i] = officeNameList[i+1];
			jobList[i] = jobList[i+1];
			phoneList[i] = phoneList[i+1];
			officePhoneList[i] = officePhoneList[i+1];
			emailList[i] = emailList[i+1];
		}
		//여기에 들어가야 할 내용은?
		count--;
	}

	private static void updateNameCardInfo(int idx) {
//		System.out.printf("이름(%s):", nameList[idx]);
//		String name = scan.nextLine().trim();
//		if(name == null || name.length()==0) {
//			//nothing
//		}else {
//			nameList[idx] = name;
//		}
//		updateNameCardDetail("이름", nameList, idx);
		updateNameCardDetail("회사명", officeNameList, idx);
		updateNameCardDetail("직무", jobList, idx);
		updateNameCardDetail("전화번호", phoneList, idx);
		updateNameCardDetail("회사전화번호", officePhoneList, idx);
		updateNameCardDetail("이메일", emailList, idx);
	}
	
	private static void updateNameCardDetail(String msg, String[] list, int idx) {
		System.out.printf("%s(%s):", msg, list[idx]);
		String str = scan.nextLine().trim();
		if(str == null || str.length()==0) {
			//nothing
		}else {
			list[idx] = str;
		}
	}
	
	private static int searchNameCardByName() {
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine().trim();
		for(int i=0; i<count; i++) {
			if(nameList[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private static void insertNameCardInfo() {
		System.out.print("이름 : ");	
		nameList[count] = scan.nextLine().trim();
		System.out.print("회사명 : ");
		officeNameList[count] = scan.nextLine().trim();
		System.out.print("직무 : ");
		jobList[count] = scan.nextLine().trim();
		System.out.print("전화번호 : ");
		phoneList[count] = scan.nextLine().trim();
		System.out.print("회사전화번호 : ");
		officePhoneList[count] = scan.nextLine().trim();
		System.out.print("이메일주소 : ");
		emailList[count] = scan.nextLine().trim();
		printNameCardInfo(count);
		count++;
	}
	private static void printNameCardInfo(int idx) {
		System.out.printf("이름: %s, 회사명: %s, 직무: %s, \n전화: %s, 회사전화: %s, 이메일: %s\n", 
				nameList[idx], officeNameList[idx], jobList[idx], phoneList[idx], 
				officePhoneList[idx], emailList[idx]);
	}
}//end class
