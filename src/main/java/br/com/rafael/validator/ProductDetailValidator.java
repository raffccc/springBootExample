package br.com.rafael.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.rafael.entity.ProductDetail;

@Component
public class ProductDetailValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDetail.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ProductDetail detail = (ProductDetail)target;
		
		if (!isValid(detail)) {
			errors.rejectValue("inventoryId", "inventory.id.invalid", "Invalid Inventory ID");
		}
		
	}

	//This should be a invocation of a specialized service, but for the sake of brevity the validation will go here
	private boolean isValid(ProductDetail detail) {
		Optional<String> inventoryIdOpt = Optional.ofNullable(detail.getInventoryId());
		return inventoryIdOpt.orElse("").length() > 3;
	}

}
