package Demo.RestfulAPI.DTO;

import lombok.Data;

@Data 
public class ProductDTO {
	
	private int id;

	private String nameProduct;
	
	private String category;
	
	private long unitPrice;
	
	private int amount;
	
	private String imageUrl ;
}
