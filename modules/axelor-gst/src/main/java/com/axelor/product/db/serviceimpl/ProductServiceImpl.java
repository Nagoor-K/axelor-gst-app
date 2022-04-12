package com.axelor.product.db.serviceimpl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axelor.product.db.Category;
import com.axelor.product.db.service.ProductService;

public class ProductServiceImpl implements ProductService{

	protected Logger log = LoggerFactory.getLogger(getClass());
  @Override
  public BigDecimal setupGst(Category category) {
    return category.getGstrate();
  }}
