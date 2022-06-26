package Demo.RestfulAPI.Converter;

import org.springframework.stereotype.Component;

import Demo.RestfulAPI.DTO.ProductDTO;
import Demo.RestfulAPI.Model.ProductModel;

@Component
public class ProductConverter {
	public ProductModel toEntity(ProductDTO productDTO) {
		ProductModel productModel = new ProductModel();
		productModel.setId(productDTO.getId());
		productModel.setNameProduct(productDTO.getNameProduct());
		productModel.setAmount(productDTO.getAmount());
		productModel.setCategory(productDTO.getCategory());
		productModel.setUnitPrice(productDTO.getUnitPrice());
		productModel.setImageUrl(productDTO.getImageUrl());
		return productModel;
	}

	public ProductDTO toDTO(ProductModel productModel) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productModel.getId());
		productDTO.setNameProduct(productModel.getNameProduct());
		productDTO.setAmount(productModel.getAmount());
		productDTO.setCategory(productModel.getCategory());
		productDTO.setUnitPrice(productModel.getUnitPrice());
		productDTO.setImageUrl(productModel.getImageUrl());
		return productDTO;
	}
	
	public ProductModel toEntity(ProductDTO productDTO,ProductModel productModel) {
		productModel.setId(productDTO.getId());
		productModel.setNameProduct(productDTO.getNameProduct());
		productModel.setAmount(productDTO.getAmount());
		productModel.setCategory(productDTO.getCategory());
		productModel.setUnitPrice(productDTO.getUnitPrice());
		productModel.setImageUrl(productDTO.getImageUrl());
		return productModel;
	}
}
