package calProject.calculator3;

@FunctionalInterface
public interface Calculator<T extends Number> {

    T cal(T num1, T num2);

}
