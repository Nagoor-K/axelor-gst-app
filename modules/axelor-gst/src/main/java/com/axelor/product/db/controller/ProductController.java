package com.axelor.product.db.controller;

import java.math.BigDecimal;

import com.axelor.product.db.Category;
import com.axelor.product.db.Product;
import com.axelor.product.db.service.ProductService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
public class ProductController {
	@Inject
	private ProductService productService;
	
	public void setGst(ActionRequest request,ActionResponse response) {
		Product product=request.getContext().asType(Product.class);
		Category category=product.getCategory();
		BigDecimal gst=productService.setupGst(category);
		response.setValue("gstrate", gst);
	}
}
