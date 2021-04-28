package core.basesyntax.dto;

import core.basesyntax.model.Operation;

public class TransactionDto {
    private final Operation operation;
    private final String product;
    private final int quantity;

    public TransactionDto(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
