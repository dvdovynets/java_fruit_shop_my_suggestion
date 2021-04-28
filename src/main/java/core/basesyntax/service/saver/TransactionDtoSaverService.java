package core.basesyntax.service.saver;

import core.basesyntax.dto.TransactionDto;

import java.util.List;

public interface TransactionDtoSaverService {
    void save(List<TransactionDto> transactionDtoList);
}
