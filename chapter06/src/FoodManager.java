import java.util.Scanner;

public class FoodManager {
	static final int MAX = 100;
	static String[] foodNameList = new String[MAX];
	static int[] countList = new int[MAX];
	static String[] expDateList = new String[MAX];
	static String[] etcList = new String[MAX];
	
	static int index = -1;
	static int count = 0;
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("1.식자제추가, 2.식자제목록, 3.식자제수정, 4.식자제삭제, 0.종료");
			System.out.print("메뉴:");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("새로운 식자제를 추가합니다.");
				insertFood();
				break;
			case 2:
				System.out.println("식자제 목록을 출력합니다.");
				printFoodList();
				break;
			case 3:
				System.out.println("식자제 정보를 수정합니다.");
				updateFoodCount();
				break;
			case 4:
				System.out.println("식자제 정보를 삭제합니다.");
				deleteFood();
				break;
			case 0:
				System.out.println("식자제 관리 프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘 못된 메뉴입니다.");
				break;
			}//end switch
		}//end while
	}//end main

	private static void updateFoodCount() {
		System.out.print("수정할 음식 이름을 입력하세요:");
		String food = scan.next();
		for(int i=0; i<count; i++) {
			if(foodNameList[i].equals(food)) {
				System.out.print("수량을 입력하세요:");
				int cnt = scan.nextInt();
				if(cnt==0) {
					for(int j=i; j<count-1; j++) {
						foodNameList[j] = foodNameList[j+1];
						countList[j] = countList[j+1];
						expDateList[j] = expDateList[j+1];
						etcList[j] = etcList[j+1];
					}
					count--;
				}else {
					countList[i] = cnt;
				}
				break;
			}//end if
		}//end for
		System.out.println("수정할 음식이 없습니다.");
	}//end updateFoodCount()

	private static void deleteFood() {
		System.out.print("삭제할 음식 이름을 입력하세요:");
		String food = scan.next();
		for(int i=0; i<count; i++) {
			if(foodNameList[i].equals(food)) {
				for(int j=i; j<count-1; j++) {
					foodNameList[j] = foodNameList[j+1];
					countList[j] = countList[j+1];
					expDateList[j] = expDateList[j+1];
					etcList[j] = etcList[j+1];
				}
				count--;
				break;
			}
		}
		System.out.println("삭제할 음식이 없습니다.");
	}

	private static void printFoodList() {
		System.out.println("-------------------------------------------");
		System.out.println("이름\t수량\t유통기한\t설명");
		System.out.println("-------------------------------------------");
		for(int i=0; i<count; i++) {
			System.out.printf("%s\t%d\t%s\t%s\n",
					foodNameList[i], countList[i], expDateList[i], etcList[i]);
		}
		System.out.println("-------------------------------------------");
	}

	private static void insertFood() {
		System.out.print("식품이름:"); foodNameList[count] = scan.next();
		System.out.print("수량:"); countList[count] = scan.nextInt();
		System.out.print("유통기한:"); expDateList[count] = scan.next();
		System.out.print("설명:"); etcList[count] = scan.next();
		count++;
	}//end insertFood
}//end class
