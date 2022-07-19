package Demo.RestfulAPI.Converter;

import org.springframework.stereotype.Component;

import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity productModel = new ProductEntity();
		productModel.setId(productDTO.getId());
		productModel.setNameProduct(productDTO.getNameProduct());
		productModel.setAmount(productDTO.getAmount());
		productModel.setCategory(productDTO.getCategory());
		productModel.setUnitPrice(productDTO.getUnitPrice());
		productModel.setImageUrl(productDTO.getImageUrl());
		return productModel;
	}

	public ProductDTO toDTO(ProductEntity productModel) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productModel.getId());
		productDTO.setNameProduct(productModel.getNameProduct());
		productDTO.setAmount(productModel.getAmount());
		productDTO.setCategory(productModel.getCategory());
		productDTO.setUnitPrice(productModel.getUnitPrice());
		productDTO.setImageUrl(productModel.getImageUrl());
		return productDTO;
	}
	
	public ProductEntity toEntity(ProductDTO productDTO,ProductEntity productModel) {
		productModel.setId(productDTO.getId());
		productModel.setNameProduct(productDTO.getNameProduct());
		productModel.setAmount(productDTO.getAmount());
		productModel.setCategory(productDTO.getCategory());
		productModel.setUnitPrice(productDTO.getUnitPrice());
		productModel.setImageUrl(productDTO.getImageUrl());
		return productModel;
	}
}
