package core.basesyntax.model;

import core.basesyntax.exception.InvalidOperationFormat;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"), SUPPLY("s"), RETURN("r"), PURCHASE("p");

    private static final String OPERATION_EXCEPTION_MESSAGE = "Invalid operation format";

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationByLetter(String operation) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() ->
                        new InvalidOperationFormat(OPERATION_EXCEPTION_MESSAGE
                                + ", " + operation));
    }
}
