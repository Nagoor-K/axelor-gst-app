package com.axelor.product.db.controller;

import java.math.BigDecimal;
import java.util.List;

import com.axelor.address.db.Address;
import com.axelor.address.db.Contact;
import com.axelor.company.db.Company;
import com.axelor.invoice.db.Invoice;
import com.axelor.invoice.db.InvoiceLine;
import com.axelor.party.db.Party;
import com.axelor.product.db.Product;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceController {
	
	public void setDefaults(ActionRequest request, ActionResponse response) {
		Invoice invoice=request.getContext().asType(Invoice.class);
		Party party=invoice.getParty();
		Contact contact=party.getContactList().get(0);
		response.setValue("partycontact", contact);
		
//		List<Address> addresses=party.getAddresset();
//		for(Address address:addresses) {
//			if(address.getType()=="Default" || address.getType()=="Invoice") {
//				response.setValue("invoiceaddress", address);
//				break;
//			}
//		}
		
		Address address=party.getAddresset().get(0);
		response.setValue("invoiceaddress", address);
		
	}
	public void invoicesetup(ActionRequest request, ActionResponse response) {
		Invoice invoice=request.getContext().asType(Invoice.class);
		BigDecimal igst=invoice.getInvoiceitems().get(0).getIgst();
		BigDecimal cgst=invoice.getInvoiceitems().get(0).getCgst();
		BigDecimal sgst=invoice.getInvoiceitems().get(0).getSgst();
		BigDecimal netamt=invoice.getInvoiceitems().get(0).getNetamt();
		BigDecimal grossamt=invoice.getInvoiceitems().get(0).getGrossamt();
		
		response.setValue("igst", igst);
		response.setValue("cgst", cgst);
		response.setValue("sgst", sgst);
		response.setValue("netamt", netamt);
		response.setValue("grossamt", grossamt);
		
		
		
	}
	
	
	
}
