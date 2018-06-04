package com.niit.dao;
import java.util.*;

import com.niit.model.supplier;


public interface supplierDao {
	public boolean addsupplier(supplier supplier);
	public supplier getsupplier(int supplier_Id);
	public boolean deletesupplier(supplier supplier);
	public boolean updatesupplier(supplier supplier);
	public List<supplier> getsuppliers();

}
