package core.basesyntax.service.parser.impl;

import core.basesyntax.dto.TransactionDto;
import core.basesyntax.exception.EntryFormatException;
import core.basesyntax.model.Operation;
import core.basesyntax.service.parser.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String CSV_FORMAT = "[b,s,r,p],[a-z]+,[0-9]+";
    private static final String SKIP_TITLE = "type,fruit,quantity";
    private static final String SPLITERATOR = ",";
    private static final String ENTRY_FORMAT_EXCEPTION_MESSAGE =
            String.format("Entry format should be %s", CSV_FORMAT);
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<TransactionDto> parse(List<String> records) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (String record : records) {
            if (record.equals(SKIP_TITLE)) {
                continue;
            }
            if (!record.matches(CSV_FORMAT)) {
                throw new EntryFormatException(ENTRY_FORMAT_EXCEPTION_MESSAGE);
            }
            transactionDtoList.add(parseLineFromCsv(record));
        }
        return transactionDtoList;
    }

    private TransactionDto parseLineFromCsv(String record) {
        String[] fields = record.split(SPLITERATOR);
        Operation operation = Operation.getOperationByLetter(fields[OPERATION_INDEX]);
        String product = fields[PRODUCT_INDEX];
        int quantity = Integer.parseInt(fields[QUANTITY_INDEX]);
        return new TransactionDto(operation, product, quantity);
    }
}
