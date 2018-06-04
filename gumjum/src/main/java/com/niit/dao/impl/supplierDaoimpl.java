package com.niit.dao.impl;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.supplierDao;
import com.niit.model.supplier;

	

	@Repository("supplierDAO")

	public class supplierDaoimpl implements supplierDao{
		@Autowired
		SessionFactory sessionFactory;
		
		@Transactional
	   public boolean addsupplier(supplier supplier) {
			
			try
			{
			sessionFactory.getCurrentSession().save(supplier);
		    
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised:"+e);
			return false;
			}
			
		}
			
		//@Override
		public supplier getsupplier(int supplier_Id) {
			Session session=sessionFactory.openSession();
			supplier supplier=(supplier)session.get(supplier.class,supplier_Id);
			session.close();
			return supplier;
		}
		
		@Transactional
		//@Override
		public boolean deletesupplier(supplier supplier) {
			try
			{
				sessionFactory.getCurrentSession().delete(supplier);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}
		}
		@Transactional
		//@Override
		public boolean updatesupplier(supplier supplier) {
			try
			{
				sessionFactory.getCurrentSession().update(supplier);
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised:"+e);
				return false;
			}
		
		}

		//@Override
		public List<supplier> getsuppliers() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from supplier");
			List<supplier> listsuppliers=(List<supplier>)((org.hibernate.query.Query) query).list();
			return listsuppliers;

		
		}

	}

