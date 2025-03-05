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
    //입력된 변수를 Enem 에 적용하여 값을 반환하는 함수 생성
    public static Number calculator(Number num1, Number num2, String sign){
        SignCal changeSign = SignCal.fromSign(sign); //sign 문자를 Enum상수로 변환
        return changeSign.cal(num1, num2); // 계산
    }
    //Main 에서 입력된 변수를 계산하여 결과값을 반환하고 기록 저장 리스트에 추가
    Number calculate(Number num1, Number num2,String sign ) {
        Number result = calculator(num1, num2, sign);
        calData.add(new ArithmeticCalculator(num1, num2, sign, result));
        return result;
    }

    //계산 결과 리스트를 입력받을 시 계산 내역 표시
    public void announce(List<ArithmeticCalculator> historyList){
        for (ArithmeticCalculator data : historyList) {
            Number num1 = data.getNum1();
            Number num2 = data.getNum2();
            String sign = data.getSign();
            Number result = data.getResult();

            //객체 내 정보 가져오기
            System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
        }
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
