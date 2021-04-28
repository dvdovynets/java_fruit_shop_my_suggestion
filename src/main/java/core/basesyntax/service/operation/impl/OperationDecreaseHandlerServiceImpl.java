package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.exception.QuantityFormatException;
import core.basesyntax.service.operation.OperationHandlerService;
import java.util.Optional;

public class OperationDecreaseHandlerServiceImpl implements OperationHandlerService {
    private static final String QUANTITY_FORMAT_EXCEPTION_MESSAGE = "You can't purchase product from empty storage";
    private final ProductDao productDao;

    public OperationDecreaseHandlerServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public int apply(TransactionDto dto) {
        Optional<Integer> currentQuantity = productDao.get(dto.getProduct());
        if (!currentQuantity.isPresent() || currentQuantity.get() <= dto.getQuantity()) {
            throw new QuantityFormatException(QUANTITY_FORMAT_EXCEPTION_MESSAGE);
        }
        return currentQuantity.get() - dto.getQuantity();
    }
}
