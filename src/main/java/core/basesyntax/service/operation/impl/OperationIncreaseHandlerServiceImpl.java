package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.service.operation.OperationHandlerService;
import java.util.Optional;

public class OperationIncreaseHandlerServiceImpl implements OperationHandlerService {
    private final ProductDao productDao;

    public OperationIncreaseHandlerServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public int apply(TransactionDto dto) {
        Optional<Integer> currentQuantity = productDao.get(dto.getProduct());
        int newQuantity = dto.getQuantity();
        if (currentQuantity.isPresent()) {
            newQuantity += currentQuantity.get();
        }
        return newQuantity;
    }
}
