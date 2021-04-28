package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.file.FileReaderService;
import core.basesyntax.service.file.FileWriterService;
import core.basesyntax.service.file.impl.FileReaderServiceImpl;
import core.basesyntax.service.file.impl.FileWriterServiceImpl;
import core.basesyntax.service.operation.OperationHandlerService;
import core.basesyntax.service.operation.impl.OperationDecreaseHandlerServiceImpl;
import core.basesyntax.service.operation.impl.OperationIncreaseHandlerServiceImpl;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.parser.impl.ParserServiceImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.impl.ReportServiceImpl;
import core.basesyntax.service.saver.TransactionDtoSaverService;
import core.basesyntax.service.saver.impl.TransactionDtoSaverServiceImpl;
import core.basesyntax.service.strategy.OperationStrategyService;
import core.basesyntax.service.strategy.impl.OperationStrategyServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ProductShopApplication {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_FILE_OUTPUT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
        OperationStrategyService operationStrategyService =
                new OperationStrategyServiceImpl(getOperationHandlerServiceMap(productDao));
        FileReaderService reader = new FileReaderServiceImpl();
        ParserService parser = new ParserServiceImpl();
        TransactionDtoSaverService saver = new TransactionDtoSaverServiceImpl(productDao, operationStrategyService);
        saver.save(parser.parse(reader.read(PATH_TO_INPUT_FILE)));
        ReportService reporter = new ReportServiceImpl(productDao);
        FileWriterService writer = new FileWriterServiceImpl();
        writer.write(PATH_TO_FILE_OUTPUT, reporter.report());
    }

    private static Map<Operation, OperationHandlerService> getOperationHandlerServiceMap(ProductDao productDao) {
        Map<Operation, OperationHandlerService> operationHandlerServiceMap = new HashMap<>();
        operationHandlerServiceMap.put(Operation.BALANCE, new OperationIncreaseHandlerServiceImpl(productDao));
        operationHandlerServiceMap.put(Operation.RETURN, new OperationIncreaseHandlerServiceImpl(productDao));
        operationHandlerServiceMap.put(Operation.SUPPLY, new OperationIncreaseHandlerServiceImpl(productDao));
        operationHandlerServiceMap.put(Operation.PURCHASE, new OperationDecreaseHandlerServiceImpl(productDao));
        return operationHandlerServiceMap;
    }
}
