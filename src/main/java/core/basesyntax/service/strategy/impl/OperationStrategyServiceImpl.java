package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operation.OperationHandlerService;
import core.basesyntax.service.strategy.OperationStrategyService;
import java.util.Map;

public class OperationStrategyServiceImpl implements OperationStrategyService {
    private final Map<Operation, OperationHandlerService> operationHandlerServiceMap;

    public OperationStrategyServiceImpl(Map<Operation, OperationHandlerService> operationHandlerServiceMap) {
        this.operationHandlerServiceMap = operationHandlerServiceMap;
    }

    @Override
    public OperationHandlerService get(Operation operation) {
        return operationHandlerServiceMap.get(operation);
    }
}
