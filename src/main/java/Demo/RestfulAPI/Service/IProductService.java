package Demo.RestfulAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.RestfulAPI.Converter.ProductConverter;
import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.ExceptionHandler.NotFoundException;
import Demo.RestfulAPI.ExceptionHandler.ProductExceptionHandler;
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
		if (productModels == null) {
			 throw new NotFoundException("No prodct found");
		}
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
		if (productModel == null) {
			throw new NotFoundException("No product found");
		}
		ProductModel ProductUpdate = productConverter.toEntity(productDTO, productModel);
		ProductUpdate = productRepository.save(ProductUpdate);
		return productConverter.toDTO(ProductUpdate);
	}

	@Override
	public ProductModel findById(Integer id) {
		ProductModel productModel = productRepository.findOneById(id);
		if (productModel==null) {
			throw new NotFoundException("No product found");
		}
			return productModel;
	}

	@Override
	public List<ProductDTO> findByName(String nameproduct) {
		List<ProductModel>  productModels = productRepository.findByNameProduct(nameproduct);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (ProductModel productModel : productModels) {
			ProductDTO productDTO = new ProductDTO();
			productDTO = productConverter.toDTO(productModel);
			productDTOs.add(productDTO);
		}
		return productDTOs;
		 
	}
}
