package my.spring.test.app;

import org.springframework.data.jpa.repository.JpaRepository;

import my.spring.test.app.model.InventoryItem;


public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

	
}
