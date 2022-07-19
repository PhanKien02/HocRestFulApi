package Demo.RestfulAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.RestfulAPI.Converter.ProductConverter;
import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Entity.ProductEntity;
import Demo.RestfulAPI.Repository.ProductRepository;
import Exception.NotFoundException;

@Service
public class IProductService implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductConverter productConverter;

	private ProductEntity productModel;

	@Override
	public List<ProductDTO> getProduct() {
		List<ProductEntity> productModels = productRepository.findAll();
		if (productModels == null) {
			throw new NotFoundException("No prodct found");
		}
		List<ProductDTO> productDTOs = new ArrayList<>();

		for (ProductEntity productModel : productModels) {
			ProductDTO productDTO = new ProductDTO();
			productDTO = productConverter.toDTO(productModel);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		ProductEntity productModel = productConverter.toEntity(productDTO);
		productModel = productRepository.save(productModel);
		return productConverter.toDTO(productModel);

	}

	@Override
	public void deleteProduct(int ID[]) {
		for (int id : ID)
			productRepository.deleteById(id);
		throw new NotFoundException("No product found");
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		ProductEntity productModel = findById(productDTO.getId());
		if (productModel != null) {
			ProductEntity ProductUpdate = productConverter.toEntity(productDTO, productModel);
			ProductUpdate = productRepository.save(ProductUpdate);
			return productConverter.toDTO(ProductUpdate);
		} else
			throw new NotFoundException("No product found");
	}

	@Override
	public ProductEntity findById(Integer id) {
		productModel = productRepository.findOneById(id);
		return productModel;
	}

	@Override
	public List<ProductDTO> findByName(String nameproduct) {
		List<ProductEntity> productModels = productRepository.findByNameProduct(nameproduct);
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (ProductEntity productModel : productModels) {
			ProductDTO productDTO = new ProductDTO();
			productDTO = productConverter.toDTO(productModel);
			productDTOs.add(productDTO);
		}
		return productDTOs;
	}
}
