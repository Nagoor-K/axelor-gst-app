package com.axelor.product.db.controller;

import com.axelor.company.db.Sequences;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class SequenceController {
	
	public void sequenceGenereator(ActionRequest request, ActionResponse response) {
		Sequences sequences=request.getContext().asType(Sequences.class);
		String prefix=sequences.getPrefix();
		String suffix=sequences.getSuffix();
		int padding=sequences.getPadding();
		String srt=String.format("%04d", padding);
		String nxt=prefix+srt+suffix;
		response.setValue("nextnumber", nxt);
	}
}
