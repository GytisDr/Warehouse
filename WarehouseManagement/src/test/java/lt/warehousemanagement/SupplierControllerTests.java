package lt.warehousemanagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import lt.warehousemanagement.controllers.SupplierController;
import lt.warehousemanagement.entities.Supplier;
import lt.warehousemanagement.services.SupplierService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SupplierController.class)
public class SupplierControllerTests {
	
	@MockBean
	SupplierService supplierService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void failsIfSupplierServiceIsNotAutowired() {
		Assertions.assertThat(supplierService).isNotNull();
	}
	
	@Test
	void failsIfNoSupplierProvidedByService() throws Exception {
		Supplier supplier = new Supplier("Test","TestLocation","TestEmail@email.com","+37015512515");
		List<Supplier> suppliers = Arrays.asList(supplier);
		
		Mockito.when(supplierService.getAll()).thenReturn(suppliers);
		
		mockMvc.perform(get("/suppliers/all"))
			.andExpect(status().isOk())
			.andExpect(view().name("/suppliers/supplier-list"))
			.andExpect(model().attributeExists("suppliers"));
	}
	
	@Test
	void returnsAddSupplierTemplate() throws Exception {
		
		mockMvc.perform(get("/suppliers/create"))
			.andExpect(status().isOk())
			.andExpect(view().name("/suppliers/add-supplier"));
	}
	
	@Test
	void shouldCreateNewSupplier() throws Exception {
		mockMvc.perform(post("/suppliers/save")
				.param("name","TestName")
				.param("location","TestLoaction")
				.param("email", "TestEmail@email.com")
				.param("phoneNumber", "+3653255235"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/suppliers/create"));
		
	}

}
