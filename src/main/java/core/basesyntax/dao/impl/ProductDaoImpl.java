package core.basesyntax.dao.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(String product, int quantity) {

        Storage.getStorage().put(product, quantity);
    }

    @Override
    public Optional<Integer> get(String key) {
        return Optional.ofNullable(Storage.getStorage().get(key));
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.getStorage();
    }
}
