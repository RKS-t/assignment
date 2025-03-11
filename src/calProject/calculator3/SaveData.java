package calProject.calculator3;

public class SaveData {

    private Number num1;
    private Number num2;
    private String sign;
    private Number result;

    public SaveData(Number num1, Number num2, String sign, Number result) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.result = result;
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




}
