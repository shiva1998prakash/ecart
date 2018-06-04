package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class supplier {
		@Id
		@Column
		//@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
		private int supplierId;
		@Column
		private String supplier_fname;
		@Column
		private String supplier_address;
		
		
		public supplier(){}
		public supplier(int supplierId, String supplier_fname, String supplier_address
				)
		{
			super();
			this.supplierId = supplierId;
			this.supplier_fname= supplier_fname;
			this.supplier_address = supplier_address;
			
		}
		public int getsupplierId() {
			return supplierId;
		}
		public void setsupplierId(int supplierId) {
			this.supplierId = supplierId;
		}
		public String getsupplier_fname() {
			return supplier_fname;
		}
		public void setsupplier_fname(String supplier_fname) {
			this.supplier_fname = supplier_fname;
		}
		public String getsupplier_address() {
			return supplier_address;
		}
		public void setsupplier_address(String supplier_address) {
			this.supplier_address = supplier_address;
		}
		
		
		
	}



