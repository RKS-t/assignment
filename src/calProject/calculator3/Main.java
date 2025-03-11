package calProject.calculator3;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        //인스턴스화
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator( );
        //계산 반복
        String exit = null ;
        while (!"exit".equals(exit)) {
            try {
                System.out.print("첫번째 수를 입력해주세요: ");
                Number num1 = value.nextDouble();

                System.out.print("두번째 수를 입력해주세요: ");
                Number num2 = value.nextDouble();
                value.nextLine(); //줄바꿈제거

                //사칙연산 기호를 입력받기
                System.out.print("사직연산 기호(+,-,*,/)중 하나를 입력해 주세요: ");
                String sign = value.nextLine();

                    if (num2.doubleValue() == 0 && sign.equals("/")) {
                        System.out.println("0으로 나눌 수 없습니다.");
                    } else {
                        Number result = arithmeticCalculator.calculate(num1, num2, sign);
                        System.out.println(num1 + " " + sign + " " + num2 + " = " + result + "입니다.");
                    }

            } catch (InputMismatchException n) {
                System.out.println("숫자를 입력해주세요."); //숫자가 아닌 다른 문자 입력받을 때 예외 처리
                value.nextLine();
                continue;//줄바꿈제거
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 문자입니다.");
                continue;//enum 요소 예외처리
            }

            System.out.print("계산기 종료를 원하시면 'exit'를 아니면 아무키나 입력해주세요. 다른키를 누르면 종료됩니다.: ");
            exit = value.nextLine();

        }
        //컬렉션 정보 가져오기
        List<SaveData> historyList = arithmeticCalculator.getData();

        if (historyList == null || historyList.isEmpty()) {
            System.out.println("계산내역이 없으므로 바로 계산기를 종료합니다.");
        } else{
            System.out.print("계산 내역을 출력하시겠습니까? 출력을 원하시면 y를 누르세요: ");
            String historyYN = value.nextLine();
            if (historyYN.equals("y")) {
                //어나운스 매소드 불러오기
                arithmeticCalculator.announce(historyList);
                //삭제 반복문

                String removeYN = "y";
                while ("y".equals(removeYN)) {
                    System.out.print("가장 오래된 계산 내역을 삭제하시겠습니까? 삭제하고 싶으시면 'y' 를 눌러주세요. 다른키를 누르면 종료됩니다.: ");
                    removeYN = value.nextLine();

                    //삭제함수
                    arithmeticCalculator.deleteData(historyList);

                    //게터로 다시 가져오기
                    historyList = arithmeticCalculator.getData();

                    //삭제 후 히스토리 읽기
                    arithmeticCalculator.announce(historyList);


                    if(historyList == null || historyList.isEmpty()) {
                        System.out.println("더 이상 삭제 할 수 없습니다. 계산기를 종료합니다.");
                    }

                }

                System.out.println("계산기를 종료합니다.");

            }

        }
    }
}

