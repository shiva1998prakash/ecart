package com.niit.controller;

     import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;

	import com.niit.dao.supplierDao;

    import com.niit.model.supplier;

	@Controller
	public class SupplierController { 
		@Autowired
		supplierDao supplierdao;

		boolean flag = true;
		
		

		@RequestMapping("/supplier")
		public String showCategory(Model m) {
			List<supplier> listsuppliers = supplierdao.getsuppliers();
			m.addAttribute("listsuppliers", listsuppliers);

			for (supplier supplier : listsuppliers) {
				System.out.println(supplier.getsupplier_fname() + ",");
			}
			flag = false;
			return "supplier";
		}

		@RequestMapping(value = "/Insertsupplier", method = RequestMethod.POST)
		public String insertsupplierData(@RequestParam("supplier_fname") String supname, @RequestParam("supplier_address") String supadd,
				Model m) {
			supplier supplier = new supplier();
			supplier.setsupplier_fname(supname);
			supplier.setsupplier_address(supadd);

			supplierdao.addsupplier(supplier);

			List<supplier> listsuppliers = supplierdao.getsuppliers();
			m.addAttribute("listsuppliers", listsuppliers);
			flag = false;
			return "supplier";
		}

		@RequestMapping("/deletesupplier/{supplierId}")
		public String deleteCategory(@PathVariable("supplierId") int supplierId,Model m)
		{
			supplier supplier=supplierdao.getsupplier(supplierId);
			
			supplierdao.deletesupplier(supplier);
			
			List<supplier> listsuppliers=supplierdao.getsuppliers();
			m.addAttribute("listsuppliers",listsuppliers);
			flag=false;
			return "supplier";
		}

		@RequestMapping("/updatesupplier/{supplierId}")
		public String updatesupplier(@PathVariable("supplierId") int supplierId,Model m)
		{
			supplier supplier=supplierdao.getsupplier(supplierId);
			
			
			List<supplier> listsuppliers=supplierdao.getsuppliers();
			m.addAttribute("listsupplier",listsuppliers);
			m.addAttribute("supplierInfo",supplier);
			
			return "Updatesupplier";
		}
	
		
		@RequestMapping(value="/Updatesupplier",method=RequestMethod.POST)
		public String updatesupplierInDB(@RequestParam("supid") int supplierId,@RequestParam("supname")String supplier_fname,
				@RequestParam("supadd") String supplier_address,Model m)
		{	
			supplier supplier=supplierdao.getsupplier(supplierId);
			supplier.setsupplier_fname(supplier_fname);
			supplier.setsupplier_address(supplier_address);
			
			supplierdao.updatesupplier(supplier);
			
			List<supplier> listsuppliers=supplierdao.getsuppliers();
			m.addAttribute("listsuppliers",listsuppliers);
			
			return "supplier";
		}
	}
