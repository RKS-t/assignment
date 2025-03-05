package calProject.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    //계산 과정을 저장하는 객체 컬렉션 추가
    private ArrayList<Calculator> calData = new ArrayList<>();

    //속성 변수 선언
    private int num1;
    private int num2;
    private char sign;
    private int[] result;

    //생성자
    public Calculator(int num1, int num2, char sign, int[] result) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.result = result;
    }

    //매서드 함수 생성
    int[] Cal(int num1, int num2, char sign) {
        int[] result = null;
        //위의 값을 가지고 연산 결과값 출력하기
        if(sign == '+'){
            result = new int[]{num1 + num2, 0};
        } else if(sign == '-'){
            result = new int[]{num1 - num2, 0};
        } else if(sign == '*'){
            result = new int[]{num1 * num2, 0};
        } else if(sign == '/'){
            result = new int[]{num1 / num2, num1 % num2};
        }

        //연산 후 그 값을 저장
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.result = result;
        calData.add(new Calculator(num1, num2, sign, result));
        return result;
    }

    //각각의 데이터에 대한 읽기 권한

    public List<Calculator> getData(){
        return new ArrayList<>(calData);
    }


    public int getNum1(){
        return num1;
    }
    public int getNum2(){
        return num2;
    }
    public char getSign(){
        return sign;
    }
    public int[] getResult(){
        return result;
    }


    //가장 오래된 계산 결과를 지우는 함수 생성

    public void setcalData() throws IndexOutOfBoundsException{  //더이상 지울수 없는 오류 발생 시 메인에서 처리

            calData.remove(0);
            this.calData=new ArrayList<>(calData);
            System.out.println("가장 오래된 계산 정보가 삭제되었습니다.");

    }



    }


