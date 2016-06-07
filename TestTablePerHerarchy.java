package com.hibernate.inheritance.tabperhirarchy.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.inheritance.tabperhirarchy.model.ContractEmployee;
import com.hibernate.inheritance.tabperhirarchy.model.Employee;
import com.hibernate.inheritance.tabperhirarchy.model.RegularEmployee;
import com.hibernate.inheritance.tabperhirarchy.util.HibernateUtil;

public class TestTablePerHerarchy {

	public static void main(String[] args) {
	

		RegularEmployee regEmp=new RegularEmployee();
		regEmp.setName("Anil Kumar");
		regEmp.setSalary(45000);
		regEmp.setBonus(25000);
		
		ContractEmployee contEmp=new ContractEmployee();
		contEmp.setName("Vivek Tygi");
		contEmp.setPay_per_hour(1500);
		contEmp.setContract_duration("6 months");

		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
			sessionFactory=HibernateUtil.getSessionfactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(regEmp);
			session.save(contEmp);
			
			session.flush();	
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)session.close();
		}
	}
}
