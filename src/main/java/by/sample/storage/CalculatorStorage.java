package by.sample.storage;

import by.sample.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorStorage {

    private final List<Operation> all = new ArrayList<>();

    public Operation sum(Operation operation) {
        operation.setResult(operation.getNum1() + operation.getNum2());
        all.add(operation);
        return operation;
    }

    public Operation sub(Operation operation) {
        operation.setResult(operation.getNum1() - operation.getNum2());
        all.add(operation);
        return operation;
    }

    public Operation mod(Operation operation) {
        operation.setResult(operation.getNum1() * operation.getNum2());
        all.add(operation);
        return operation;
    }

    public Operation div(Operation operation) {
        operation.setResult(operation.getNum1() / operation.getNum2());
        all.add(operation);
        return operation;
    }

    public List<Operation> history() {
        return new ArrayList<>(all);

    }


}
