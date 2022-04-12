package com.axelor.product.db.module;

import com.axelor.app.AxelorModule;
import com.axelor.product.db.service.ProductService;
import com.axelor.product.db.serviceimpl.ProductServiceImpl;

public class ProductModule extends AxelorModule{
	
	@Override
	  protected void configure() {
		bind(ProductService.class).to(ProductServiceImpl.class);
	  }
}
