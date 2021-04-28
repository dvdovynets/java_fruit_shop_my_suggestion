package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandlerService;

public interface OperationStrategyService {
    OperationHandlerService get (Operation operation);
}
