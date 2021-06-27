package by.sample.entity;

import javax.validation.constraints.*;

public class Operation {

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Min(value = -100, message = "Invalid Num 1")
    @Max(value = 100, message = "Invalid Num 1")
    double num1;

    @Min(value = -100, message = "Invalid Num 2")
    @Max(value = 100, message = "Invalid Num 2")
//    @Pattern(regexp = "(\\d+)?\\.(\\d+)?", message = "Your enter char")
    double num2;

    @NotBlank(message = "Invalid Operation Type")
    @NotEmpty(message = "Invalid Operation Type")
    String operationName;

    double result;

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", operationName='" + operationName + '\'' +
                ", result=" + result +
                '}';
    }
}
