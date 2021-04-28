package core.basesyntax.service.report.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.service.report.ReportService;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA = ",";
    private final ProductDao productDao;

    public ReportServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public String report() {
        StringBuilder buildReport = new StringBuilder().append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entity : productDao.getAll().entrySet()) {
            buildReport.append(entity.getKey())
                    .append(COMMA)
                    .append(entity.getValue())
                    .append(System.lineSeparator());
        }
        return buildReport.toString();
    }
}
