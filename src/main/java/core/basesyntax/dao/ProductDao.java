package core.basesyntax.dao;

import java.util.Map;
import java.util.Optional;

public interface ProductDao {
    void add(String product, int quantity);

    Optional<Integer> get(String key);

    Map<String, Integer> getAll();
}
