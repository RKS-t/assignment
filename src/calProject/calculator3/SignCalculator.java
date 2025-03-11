package calProject.calculator3;




enum SignCalculator {
    ADD("+", (num1, num2)-> num1.doubleValue() + num2.doubleValue()),
    SUB("-", (num1, num2)-> num1.doubleValue() - num2.doubleValue()),
    MUL("*", (num1, num2)-> num1.doubleValue() * num2.doubleValue()),
    DIV("/", (num1, num2)-> num1.doubleValue() / num2.doubleValue());


    //저장공간 선언
    private final String sign;
    private final Calculator<Number> calculator;


    //생성자
    SignCalculator(String sign, Calculator calculator) {
        this.sign = sign;
        this.calculator = calculator;
    }

    //문자 반환
    public String getSign() {
        return sign;
    }

    //람다식 연산 실행
    public Number signCalculate(Number a, Number b) {
        return calculator.cal(a, b);
    }




    // 연산기호를 Enum으로 변환
    public static SignCalculator fromSign(String sign) {
        for (SignCalculator change : SignCalculator.values()) {
            if (change.sign.equals(sign)) {
                return change;
            }
        }
        throw new IllegalArgumentException(); //enum 에 등록된 요소가 아니면 예외처리
    }

}
