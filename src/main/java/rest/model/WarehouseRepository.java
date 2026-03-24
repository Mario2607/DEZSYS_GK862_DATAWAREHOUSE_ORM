package rest.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<WarehouseData, Long> {}
