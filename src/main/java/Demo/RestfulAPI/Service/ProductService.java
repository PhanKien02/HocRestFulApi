package Demo.RestfulAPI.Service;

import java.util.List;

import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Model.ProductModel;

public interface ProductService {

	public List<ProductDTO> getProduct();

	public ProductDTO addProduct(ProductDTO productDTO);

	public void deleteProduct(int ID[]);

	public ProductDTO updateProduct(ProductDTO productDTO);

	public List<ProductDTO> findByName(String nameProduct);

	public ProductModel findById(Integer id) ;
}
