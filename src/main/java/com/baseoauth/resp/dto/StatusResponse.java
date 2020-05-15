package com.baseoauth.resp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusResponse extends AbstractResponse {
	
	private int status;
	private String statusDesc;
		
}
