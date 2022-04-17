package com.axelor.product.db.controller;

import java.math.BigDecimal;

import com.axelor.address.db.Address;
import com.axelor.company.db.Company;
import com.axelor.invoice.db.Invoice;
import com.axelor.invoice.db.InvoiceLine;
import com.axelor.product.db.Product;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceLineController {
	
	private BigDecimal netamt;
	
	
	public void setnetamt(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		int qty=invoiceLine.getQty();
		BigDecimal price=invoiceLine.getPrice();
		netamt=price.multiply(BigDecimal.valueOf(qty));
		response.setValue("netamt", netamt);
		
		BigDecimal gstrate=invoiceLine.getGstrate();
		BigDecimal igst=netamt.multiply(gstrate);
		response.setValue("igst", igst);
		
		//BigDecimal gstrate=invoiceLine.getGstrate();
		BigDecimal sgst=netamt.multiply(gstrate);
		BigDecimal d=BigDecimal.valueOf(2);
		sgst=sgst.divide(d);
		response.setValue("sgst", sgst);
		
		response.setValue("cgst", sgst);
		
		BigDecimal grsam=netamt.add(sgst).add(igst);
		
		response.setValue("grossamt", grsam);
		
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
	
	public void setigst(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		BigDecimal gstrate=invoiceLine.getGstrate();
		BigDecimal igst=netamt.multiply(gstrate);
		response.setValue("igst", igst);
		
		 
		
	}
	
	public void setsgst(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		BigDecimal gstrate=invoiceLine.getGstrate();
		BigDecimal sgst=netamt.multiply(gstrate);
		response.setValue("sgst", sgst);
		
	}
	
	public void setcgst(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		
	}
	
	public void setgrossamt(ActionRequest request, ActionResponse response) {
		InvoiceLine invoiceLine=request.getContext().asType(InvoiceLine.class);
		
	}
	
}
