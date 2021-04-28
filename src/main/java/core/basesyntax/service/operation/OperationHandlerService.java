package core.basesyntax.service.operation;

import core.basesyntax.dto.TransactionDto;

public interface OperationHandlerService {
    int apply(TransactionDto dto);
}
