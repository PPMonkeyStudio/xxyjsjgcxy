package com.xxyjsjgcxy.slink.domain;

public class searchLinkListDTO {
private String name;




private String sqrt = "link_gmt_create";
private String sqrt_sc = "desc";



@Override
public String toString() {
	return "searchLinkListDTO [name=" + name + ", sqrt=" + sqrt + ", sqrt_sc="
			+ sqrt_sc + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public String getSqrt() {
	return sqrt;
}

public void setSqrt(String sqrt) {
	this.sqrt = sqrt;
}

public String getSqrt_sc() {
	return sqrt_sc;
}

public void setSqrt_sc(String sqrt_sc) {
	this.sqrt_sc = sqrt_sc;
}

}
