package core.basesyntax.service.parser;

import core.basesyntax.dto.TransactionDto;

import java.util.List;

public interface ParserService {
    List<TransactionDto> parse (List<String> records);
}
