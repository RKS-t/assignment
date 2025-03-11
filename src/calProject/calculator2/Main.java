package calProject.calculator2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        //객체 인스턴스화
        Calculator calculator = new Calculator();
        Scanner value = new Scanner(System.in);
        //계산 반복
        String input = null;
        while (!"exit".equals(input)) {


                int num1 = 0;
                int num2 = 0;
                char sign = 0;
                int[] result = new int[2];

                try {
                    System.out.print("첫번째 양의 정수(0포함)를 입력해주세요: ");
                    num1 = value.nextInt();
                    System.out.print("두번째 양의 정수(0포함)를 입력해주세요: ");
                    num2 = value.nextInt();
                    //사칙연산 기호를 입력받기
                    System.out.print("사직연산 기호(+,-,*,/)중 하나를 입력해 주세요: ");
                    sign = value.next().charAt(0);
                    value.nextLine(); //줄바꿈제거
                } catch (InputMismatchException e) {
                    System.out.println("올바른 숫자가 아닙니다."); // 잘못된 숫자가 입력되었을 때 예외 처리
                    value.nextLine();
                }

                if (sign == '/' && num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    result = calculator.calculate(num1, num2, sign); //인스턴스의 매서드를 사용해 계산
                    if (sign == '/') {
                        System.out.println(num1 + " / " + num2 + " = " + result[0] + "이고 나머지는" + result[1] + "입니다.");
                    } else if (sign == '*' || sign == '+' || sign == '-') {
                        System.out.println(num1 + " " + sign + " " + num2 + " = " + result[0] + "입니다.");
                    } else {
                        System.out.println("잘못된 문자입니다.");
                    }
                }


                System.out.print("계산기 종료를 원하시면 'exit'를 아니면 아무키나 입력해주세요. 다른키를 누르면 종료됩니다.: ");
                input = value.nextLine();



            //계산 내역 출력 기능
            System.out.print("계산 내역을 출력하시겠습니까? 출력을 원하시면 y를 누르세요: ");
            String historyYN = value.nextLine();

            List<SaveData> history = calculator.getData(); //컬렉션 정보 가져오기
            if (historyYN.equals("y")) {


                //향상된 for문 사용하여 history 읽기

                for (SaveData data : history) {
                    //객체 내 정보 가져오기
                    int[] dataResult = data.getResult();
                    int dataNum1 = data.getNum1();
                    int dataNum2 = data.getNum2();
                    char dataSign = data.getSign();
                    if (sign == '/') {
                        System.out.println(dataNum1 + " " + dataSign + " " + dataNum2 + " = " + dataResult[0] + " 나머지: " + dataResult[1]);
                    } else {
                        System.out.println(dataNum1 + " " + dataSign + " " + dataNum2 + " = " + dataResult[0]);
                    }
                }
                //삭제 반복문
                if (history != null && !history.isEmpty()) {
                    String removeYN = null;
                    while ("y".equals(removeYN)) {
                        System.out.print("가장 오래된 계산 내역을 삭제하시겠습니까? 삭제하고 싶으시면 'y' 를 눌러주세요. 다른키를 누르면 종료됩니다.: ");
                        removeYN = value.nextLine();
                        //가장 오래된 정보 삭제
                        calculator.deleteData();

                        //삭제 후 데이터 불러오기
                        history = calculator.getData();

                        //삭제 후 히스토리 읽기
                        for (SaveData data : history) {
                            int[] reResult = data.getResult();
                            int reNum1 = data.getNum1();
                            int reNum2 = data.getNum2();
                            char reSign = data.getSign();
                            if (reSign == '/') {
                                System.out.println(reNum1 + " " + reSign + " " + reNum2 + " = " + reResult[0] + " 나머지: " + reResult[1]);
                            } else {
                                System.out.println(reNum1 + " " + reSign + " " + reNum2 + " = " + reResult[0]);
                            }
                        }
                    }
                } else {
                    System.out.println("더 이상 삭제 할 수 없습니다. 계산기를 종료합니다.");
                }
            }

        }
    }
}

