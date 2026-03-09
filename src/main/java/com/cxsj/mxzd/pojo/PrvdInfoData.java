package com.cxsj.mxzd.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class PrvdInfoData implements Serializable {

	private int prvdId ;
	private String prvdName ;
	private String busiUnitCode ;
	private String prvdType;
}
