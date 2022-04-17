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
		List<InvoiceLine> invoiceLine=invoice.getInvoiceitems();
		BigDecimal igst=BigDecimal.valueOf(0);
		for(InvoiceLine item: invoiceLine) {
			igst=igst.add(item.getIgst());
		}
		response.setValue("netigst", igst);
		
		BigDecimal cgst=BigDecimal.valueOf(0);
		for(InvoiceLine item: invoiceLine) {
			cgst=cgst.add(item.getCgst());
		}
		response.setValue("netcgst", cgst);
		
		BigDecimal sgst=BigDecimal.valueOf(0);
		for(InvoiceLine item: invoiceLine) {
			sgst=sgst.add(item.getSgst());
		}
		response.setValue("netsgst", sgst);
		
		BigDecimal grssamt=BigDecimal.valueOf(0);
		for(InvoiceLine item: invoiceLine) {
			grssamt=grssamt.add(item.getGrossamt());
		}
		response.setValue("grossamt", grssamt);
	}
	
	
	
	
	
}
