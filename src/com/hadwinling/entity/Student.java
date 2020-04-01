package com.hadwinling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int id;
	private String sno;
	private String sname;
	private String sex;
	private String address;
	

}
