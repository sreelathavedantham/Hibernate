package org.niit.alloperationshibernate;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.niit.alloperationshibernate.model.Student;

public class App 
{
    public static void main( String[] args )
    {
       Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
       SessionFactory sf = cfg.buildSessionFactory();
       Session session = sf.openSession();
       Transaction t = session.beginTransaction();
       
       System.out.println("1.Insert record");
       System.out.println("2.Delete record");
       System.out.println("3.Update record");
       System.out.println("4.Select All  records");
       System.out.println("5.search record");
       System.out.println("Select an option");
       
       Scanner sca = new Scanner(System.in);
       
       int option = sca.nextInt();
       
       if(option==1)
       {
    	   Student s = new Student();
    	   s.setSid("s101");
    	   s.setName("Sreelatha");
    	   s.setMarks(90);
    	   s.setEmail("sreelatha@gmail.com");
    	   s.setCity("pune");
    	   session.save(s);
       }
       
       if(option==2)
       {
    	  Student s = new Student();
    	  System.out.println("Enter student ID to delete");
    	  s.setSid(sca.next());
    	  session.delete(s);
       }
       
       if(option==3)
       {
    	  Student s = new Student();
    	  s.setName("latha");
    	  s.setMarks(80);
    	  s.setEmail("latha@gmail.com");
    	  s.setCity("hyd");
    	  System.out.println("Enter student ID");
    	  s.setSid(sca.next());
    	  session.update(s);
       }
       
       if(option==4)
       {
    	  ArrayList<Student> al = new ArrayList<Student>();
    	  al=(ArrayList<Student>)session.createQuery("from Student").list();
    	  for(Student s:al)
    	  {
    		  System.out.println(s.getSid()+" "+s.getName()+" "+s.getEmail()+" "+s.getMarks()+" "+s.getCity());
    	  }
       }
       
       if(option==5)
       {
    	   Student s = new Student();
    	   System.out.println("Enter stydent ID");
    	   String Sid=sca.next();
    	   s=(Student)session.get(Student.class, Sid);
    	   System.out.println(s.toString());
    	   
       }
       
       t.commit();
       session.close();
    }
}
