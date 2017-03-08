package my.spring.test.app;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.spring.test.app.model.InventoryItem;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	private Logger log = LogManager.getLogger();
	
	@Autowired
	private InventoryRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InventoryItem>> findAll() {
		
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{itemId}")
	public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable Long itemId) {
		log.debug("Fetching item " + itemId);
		return new ResponseEntity<>(repository.findOne(itemId), HttpStatus.OK);
	}
	
	
	
}
