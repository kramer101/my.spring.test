package my.spring.test.app;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import my.spring.test.app.model.InventoryItem;


@Primary
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

	
}
