package calProject.calculator2;

import java.util.ArrayList;

public class SaveData {

    private int num1;
    private int num2;
    private char sign;
    private int[] result;

    public SaveData(int num1, int num2, char sign, int[] result) {
        this.num1 = num1;
        this.num2 = num2;
        this.sign = sign;
        this.result = result;
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
}
