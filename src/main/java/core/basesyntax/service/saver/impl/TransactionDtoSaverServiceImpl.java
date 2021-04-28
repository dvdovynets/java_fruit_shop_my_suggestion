package core.basesyntax.service.saver.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.service.saver.TransactionDtoSaverService;
import core.basesyntax.service.strategy.OperationStrategyService;

import java.util.List;

public class TransactionDtoSaverServiceImpl implements TransactionDtoSaverService {
    private final ProductDao productDao;
    public final OperationStrategyService operationStrategyService;

    public TransactionDtoSaverServiceImpl(ProductDao productDao,
                                          OperationStrategyService operationStrategyService) {
        this.productDao = productDao;
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void save(List<TransactionDto> transactionDtoList) {
        for (TransactionDto dto : transactionDtoList) {
            saveDtoToStorage(dto);
        }
    }

    private void saveDtoToStorage(TransactionDto dto) {
        int apply = operationStrategyService.get(dto.getOperation()).apply(dto);
        productDao.add(dto.getProduct(), apply);
    }
}
