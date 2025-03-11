package calProject.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static int[] result = new int[2];

    //계산 과정을 저장하는 객체 컬렉션 추가
    private List<SaveData> data = new ArrayList<>();

    //속성 변수 선언
    //생성자
    //매서드 함수 생성
    int[] calculate(int num1, int num2, char sign) {

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

        data.add(new SaveData(num1, num2, sign, result));
        return result;
    }

    //각각의 데이터에 대한 읽기 권한

    public List<SaveData> getData(){
        return data;
    }

    //가장 오래된 계산 결과를 지우는 함수 생성

    public void deleteData() {  //더이상 지울수 없는 오류 발생 시 메인에서 처리
            data.remove(0);
            this.data = new ArrayList<>(data);
            System.out.println("가장 오래된 계산 정보가 삭제되었습니다.");

    }
}


