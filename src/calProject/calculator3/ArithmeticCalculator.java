package calProject.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class  ArithmeticCalculator <T extends Number> {

    //속성 변수 선언
    //계산 과정을 저장하는 객체 컬렉션 추가 (캡슐화)
    private List<SaveData> calData = new ArrayList<>();

    // (캡슐화)


    //생성자
    public ArithmeticCalculator( ) {

    }



    //함수
    //입력된 변수를 Enem 에 적용하여 값을 반환하는 함수 생성
    public Number calculate(T num1, T num2, String sign){
        SignCalculator changeSign = SignCalculator.fromSign(sign); //sign 문자를 Enum상수로 변환
        Number result = changeSign.signCalculate(num1, num2);// 계산
        calData.add(new SaveData(num1, num2, sign, result));//데이터 저장
        return result;
    }
    //Main 에서 입력된 변수를 계산하여 결과값을 반환하고 기록 저장 리스트에 추가


    //계산 결과 리스트를 입력받을 시 계산 내역 표시
    public void announce(List<SaveData> historyList){
        for (SaveData data : historyList) {
            Number num1 = data.getNum1();
            Number num2 = data.getNum2();
            String sign = data.getSign();
            Number result = data.getResult();

            //객체 내 정보 가져오기
            System.out.println(num1 + " " + sign + " " + num2 + " = " + result);
        }
    }

    //게터
    public List<SaveData> getData(){
        return new ArrayList<>(calData);
    }




    //세터 설정
    public void deleteData(List<SaveData> historyList) {
        if(historyList != null && !historyList.isEmpty()) {
            calData = historyList.stream().skip(1).collect(Collectors.toList());
              //원래 데이터에 정보가 없으면 예외처리
        }
    }
}
