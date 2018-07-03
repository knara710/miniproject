import java.util.Scanner;
import java.util.InputMismatchException;

public class CustomerManager {

   // 배열에 저장할 수 있는 최대 고객의 수
   static final int MAX = 100;
   // 고객정보를 저장할 변수를 배열로 선언
   static String[] nameList = new String[MAX]; // 이름 저장
   static char[] genderList = new char[MAX]; // 성별 저장
   static String[] emailList = new String[MAX]; // 이메일 저장
   static int[] birthYearList = new int[MAX]; // 출생년도 저장

   // 배열은 인덱스를 필요로 함
   static int index = -1;// 배열은 0부터 시작하므로 최초 인덱스는 -1이어야 함

   // 배열은 처음 선언한 크기보다 같거나 적은 개수의 자료를 저장
   // 그래서 현재 데이터가 몇 개 저장되어있는 지 알 수 있는 변수 선언
   static int count = 0;// 개수

   // 기본 입력장치로부터 데이터를 입력받기 위해 Scanner객체 생성
   static Scanner scan = new Scanner(System.in);

   public static void main(String[] args) {

      while (true) {

         System.out.printf("\n[INFO] 고객 수 : %d, 현재선택 인덱스 : %d\n", count, index);
         System.out.println("메뉴를 입력하세요.");
         System.out.println("(I)nsert, (P)revious, (N)ext, " + "(C)urrent, (U)pdate, (D)elete, (A)llprint, (Q)uit");
         System.out.print("메뉴 입력: ");
         String menu = scan.next();
         menu = menu.toLowerCase(); // 입력한 문자열을 모두소문자로 변환
         switch (menu.charAt(0)) {
         case 'i':
            System.out.println("고객정보 입력을 시작합니다.");
            if (count >= MAX) {
               System.out.println("더 이상 저장할 수 없습니다.");
            } else {
               insertCustomerData();
            }
            break;
         case 'p':
            System.out.println("이전 데이터를 출력합니다.");
            if (index <= 0) {
               System.out.println("이전 데이터가 존재하지 않습니다.");
            } else {
               index--;
               printCustomerData();
            }
            break;
         case 'n':
            System.out.println("다음 데이터를 출력합니다.");
            if (index >= count - 1) {
               System.out.println("다음 데이터가 존재하지 않습니다.");
            } else {
               index++;
               printCustomerData();
            }
            break;
         case 'c':
            System.out.println("현재 데이터를 출력합니다.");
            if ((index >= 0) && (index < count)) {
               printCustomerData();
            } else {
               System.out.println("출력할 데이터가 선택되지 않았습니다.");
            }
            break;
         case 'u':
            System.out.println("데이터를 수정합니다.");
            if ((index >= 0) && (index < count)) {
               System.out.println(index + "번째 데이터를 수정합니다.");
               updateCustomerData();
            } else {
               System.out.println("수정할 데이터가 선택되지 않았습니다.");
            }
            break;
         case 'd':
            System.out.println("데이터를 삭제합니다.");
            if ((index >= 0) && (index < count)) {
               System.out.println(index + "번째 데이터를 삭제합니다.");
               deleteCustomerData();
            } else {
               System.out.println("삭제할 데이터가 선택되지 않았습니다.");
            }
            break;
         case 'q':
            System.out.println("프로그램을 종료합니다.");
            scan.close(); // Scanner 객체를 닫아준다.
            System.exit(0); // 프로그램을 종료시킨다.
            break;
         case 'a':
            System.out.println("모든 고객 데이터를 출력합니다.");
            allPrintCustomerData();
            break;
         default:
            System.out.println("메뉴를 잘 못 입력했습니다.");
         }// end switch
      } // end while
   }// end main

   public static void insertCustomerData() {
      System.out.print("이름 : ");
      String name = scan.next();
      System.out.print("성별(M/F) : ");
      char gender = scan.next().charAt(0);
      System.out.print("이메일 : ");
      String email = scan.next();
      if (checkEmail(email) == -1) {
         System.out.println("!!!!!!중복  E-mail address 입니다.!!!!!\n이메일:");
         email=scan.next();
      } 
      System.out.print("출생년도 : ");
      int birthYear = 0;
      while (true) {
         try {
            birthYear = scan.nextInt();
            int length = (int)(Math.log10(birthYear)+1);
             if (length!=4) {
                  System.out.println("4자리 입력 필요.\n 출생년도:");
                  birthYear=scan.nextInt();
             }
            System.out.println("고객정보를 저장했습니다.");
            break;
         } catch (InputMismatchException ime) {
            scan = new Scanner(System.in);
            System.out.println("잘못 입력하셨습니다.재입력 해주세요.\n출생년도:");
         }
      }
      
      nameList[count] = name;
      genderList[count] = gender;
      emailList[count] = email;
      birthYearList[count] = birthYear;
      count++;

   }

   // 고객데이터 출력
   public static void printCustomerData() {
      System.out.println("==========CUSTOMER INFO================");
      System.out.println("이름 : " + nameList[index]);
      System.out.println("성별 : " + genderList[index]);
      System.out.println("이메일 : " + emailList[index]);
      System.out.println("출생년도 : " + birthYearList[index]);
      System.out.println("=======================================");
   }

   // index 위치의 고객정보를 삭제합니다.
   public static void deleteCustomerData() {
      for (int i = index; i < count - 1; i++) {
         nameList[i] = nameList[i + 1];
         genderList[i] = genderList[i + 1];
         emailList[i] = emailList[i + 1];
         birthYearList[i] = birthYearList[i + 1];
      }
      count--;
   }

   // index 위치의 고객 정보를 수정합니다.
   public static void updateCustomerData() {
      System.out.println("---------UPDATE CUSTOMER INFO----------");
      System.out.print("이름(" + nameList[index] + ") :");
      nameList[index] = scan.next();

      System.out.print("성별(" + genderList[index] + ") :");
      genderList[index] = scan.next().charAt(0);

      System.out.print("이메일(" + emailList[index] + ") :");
      emailList[index] = scan.next();

      System.out.print("출생년도(" + birthYearList[index] + ") :");
      birthYearList[index] = scan.nextInt();
   }

   // 체크 이메일
   public static int checkEmail(String em) {

      int result = 0;
      for (int i = 0; i < count; i++) {
         if (emailList[i].equals(em) == true) {
            result = -1;
            break;
         }
      }
      return result; //-1 반환
   }

   // 모든 정보를 출력
   public static void allPrintCustomerData() {
      for (int i = 0; i < count; i++) {

         System.out.println("==========CUSTOMER INFO NO.(" + (i + 1) + ")============");
         System.out.println("이름 : " + nameList[i]);
         System.out.println("성별 : " + genderList[i]);
         System.out.println("이메일 : " + emailList[i]);
         System.out.println("출생년도 : " + birthYearList[i]);
      }
   }

}
// end class