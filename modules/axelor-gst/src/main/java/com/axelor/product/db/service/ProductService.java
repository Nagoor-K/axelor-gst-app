package com.axelor.product.db.service;

import java.math.BigDecimal;

import com.axelor.product.db.Category;

public interface ProductService {
	BigDecimal setupGst(Category category);
}
