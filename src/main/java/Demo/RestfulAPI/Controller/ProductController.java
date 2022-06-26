package Demo.RestfulAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Service.IProductService;

@RestController
public class ProductController {
	@Autowired
	IProductService productService;
	
	@GetMapping("Product")
	public List<ProductDTO> listProduct() {
		return productService.getProduct();
	}
	@PostMapping("Product")
	public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.addProduct(productDTO);
	}
	@DeleteMapping("Product")
	public void deleteProduct(@RequestBody int ID[]) {
			productService.deleteProduct(ID);
	}
	@PutMapping("Product/{id}")
	public ProductDTO updateProduct(@PathVariable("id") Integer id,@Valid @RequestBody ProductDTO productDTO) {
		productDTO.setId(id);
		return productService.updateProduct(productDTO);
	}
}
