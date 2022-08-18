package lt.warehousemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.warehousemanagement.entities.Supplier;
import lt.warehousemanagement.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> getAll() {
		return supplierRepository.findAll();
	}

}
