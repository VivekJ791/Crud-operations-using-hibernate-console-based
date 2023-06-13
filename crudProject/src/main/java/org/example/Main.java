package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

while(true){
        Scanner sc= new Scanner(System.in);
        System.out.println("1.insert data");
        System.out.println("2.show all data");
        System.out.println("3.update data");
        System.out.println("4.delete data");
    System.out.println("5.to show data of particular id");
    System.out.println("6.exit");

        int input = sc.nextInt();
        SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
        // we need to initialise the session right
        switch (input){
            case 1:
                //create user
                Session session= sessionFactory.openSession();
                Scanner s= new Scanner(System.in);
                System.out.println("enter id");
                int id=s.nextInt();
                System.out.println("enter first name");
                String firstname=s.next();
                System.out.println("enter last name");
                String lastname=s.next();
                System.out.println("enter email");
                String email=s.next();
                User user=new User(id,firstname,lastname,email);

                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();
                System.out.println("data saved");
                break;
            case 2:

                //read users
                Session s1=sessionFactory.openSession();
                List<User> users=s1.createQuery("from User").list();
                for ( User u:users) {
                    System.out.println(u.getId()+" "+u.getFirstname());
                }
                s1.close();
                break;
            case 3:
                //update users
                Scanner updsc=new Scanner(System.in);
                System.out.println("enter id to update");
                int up=updsc.nextInt();
                System.out.println("enter first name");
                String firstn=updsc.next();
                System.out.println("enter last name");
                String lastn=updsc.next();
                System.out.println("enter email");
                String emailUp=updsc.next();
                Session s2=sessionFactory.openSession();
                User user1=s2.get(User.class,up);

                Transaction txy=s2.beginTransaction();
                user1.setEmail(emailUp);
                user1.setLastname(lastn);
                user1.setFirstname(firstn);
                s2.update(user1);
                txy.commit();
                s2.close();
                System.out.println("data updated");
                break;
            case 4:
                // delete user
                Scanner delsc=new Scanner(System.in);
                System.out.println("enter id to delete");
                int del=delsc.nextInt();
                Session s3=sessionFactory.openSession();
                User user2=s3.get(User.class,del);
                Transaction txyz=s3.beginTransaction();
                s3.delete(user2);
                txyz.commit();
                s3.close();
                System.out.println("data deleted");
                break;

            case 5:
                //read users
                Scanner s4=new Scanner(System.in);
                System.out.println("enter id to show");
                int idread=s4.nextInt();
                Session sread=sessionFactory.openSession();
                User userwithid=sread.load(User.class,idread);
                Transaction tx=sread.beginTransaction();

                Query userid= sread.createQuery("from User where id=:idr");
                userid.setParameter("idr",idread);
//                for( User u:userid) {
//                    System.out.println(u.getId()+" "+u.getFirstname());
//                }
                System.out.println(userid.getResultList());
                tx.commit();
                sread.close();
                break;
            case 6:
                System.exit(5);
                break;
        }
    }}
}
