package calProject.calculator3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    //속성 변수 선언
    //계산 과정을 저장하는 객체 컬렉션 추가 (캡슐화)
    private List<ArithmeticCalculator> calData = new ArrayList<>();

    // (캡슐화)
    private Number num1;
    private Number num2;
    private String sign;
    private Number result;


    //생성자
    public ArithmeticCalculator(Number num1, Number num2, String sign, Number result) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.result = result;
    }



    //함수

    public Number calculator(Number num1, Number num2, String sign){
        SignCal changeSign = SignCal.fromSign(sign); //sign 문자를 Enum상수로 변환
        return changeSign.cal(num1, num2); // 계산
    }

    Number calculate(Number num1, Number num2,String sign ) {
        calData.add(new ArithmeticCalculator(num1, num2, sign, calculator(num1, num2, sign)));
        return calculator(num1, num2, sign);
    }


    //게터
    public List<ArithmeticCalculator> getData(){
        return new ArrayList<>(calData);
    }


    public Number getNum1(){
        return num1;
    }
    public Number getNum2(){
        return num2;
    }
    public String getSign(){
        return sign;
    }
    public Number getResult(){
        return result;
    }

    //세터 설정
    public void setData(List<ArithmeticCalculator> setData) {
        if(calData == null || calData.isEmpty()) {
            throw new IllegalStateException();  //원래 데이터에 정보가 없으면 예외처리
        }
        this.calData = new ArrayList<>(setData);
    }

}
