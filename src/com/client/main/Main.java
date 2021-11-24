package com.client.main;

import java.util.*;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.client.entities.Client;
import com.hibernate.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {

		Session s = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction t = (Transaction) s.beginTransaction();

		List<Client> clients = new ArrayList<Client>();

		clients = s.createQuery("Select * from Client").getResultList();

		for (Client c : clients) {
			System.out.println(c.toString());
		}
	}
}
