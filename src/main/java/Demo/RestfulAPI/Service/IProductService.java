package Demo.RestfulAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.RestfulAPI.Converter.ProductConverter;
import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Model.ProductModel;
import Demo.RestfulAPI.Repository.ProductRepository;

@Service
public class IProductService implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductConverter productConverter;

	@Override
	public List<ProductDTO> getProduct() {
		List<ProductModel> productModels = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (ProductModel productModel : productModels) {
			ProductDTO productDTO = new ProductDTO();
			productDTO = productConverter.toDTO(productModel);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		ProductModel productModel = productConverter.toEntity(productDTO);
		productModel = productRepository.save(productModel);
		return productConverter.toDTO(productModel);

	}

	@Override
	public void deleteProduct(int ID[]) {
		for (int id : ID)
			productRepository.deleteById(id);
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		ProductModel productModel = findById(productDTO.getId());
		ProductModel ProductUpdate = productConverter.toEntity(productDTO, productModel);
		ProductUpdate = productRepository.save(ProductUpdate);
		return productConverter.toDTO(ProductUpdate);
	}

	@Override
	public ProductModel findById(Integer id) {
		ProductModel productModel = productRepository.findOneById(id);
		return productModel;
	}
}
