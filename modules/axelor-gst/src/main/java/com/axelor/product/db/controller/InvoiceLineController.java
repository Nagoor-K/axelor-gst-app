package com.axelor.product.db.controller;

import java.math.BigDecimal;

import com.axelor.address.db.Address;
import com.axelor.invoice.db.Invoice;
import com.axelor.invoice.db.InvoiceLine;
import com.axelor.product.db.Product;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceLineController {
	
	public void setnetamt(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		int qty=invoiceLine.getQty();
		BigDecimal price=invoiceLine.getPrice();
		BigDecimal netamt=price.multiply(BigDecimal.valueOf(qty));
		response.setValue("netamt", netamt);
	}
	
	public void setNameofItem(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		Product product=invoiceLine.getProduct();
		String name=product.getCode();
		BigDecimal gstrate=product.getGstrate();
		response.setValue("item", name);
		response.setValue("gstrate", gstrate);
		int qty=invoiceLine.getQty();
		BigDecimal price=invoiceLine.getPrice();
		BigDecimal netamt=price.multiply(BigDecimal.valueOf(qty));
		response.setValue("igst", netamt.multiply(gstrate));
		
	}
	
}
