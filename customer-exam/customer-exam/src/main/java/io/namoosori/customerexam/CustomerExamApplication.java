package io.namoosori.customerexam;

import io.namoosori.customerexam.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerExamApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("customer-exam");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();//db에 데이터를 읽고 쓰는 단위는 트랜잭션. 보는 것과 같이 Entity메니저는 우선 트랜잭션을 가져와야 한다(getTransaction()). 그리고 그 트랜잭션안에서 데이터를 읽고
		//쓰고 변형할 작업들이 하나의 트랜잭션을 구성하게 되는 것이다. 아래와 같이 persist()호출하면 그안의 객체를 대상으로 대응되는 테이블에 데이터를 넣는다던지 하는 것. 물론 그 중간 과정에서
		//Hibernate가 자바코드를 SQL쿼리로 변환해줌.
		tx.begin();//데이터를 읽고 쓸수 있는 단계 시작!
		//이 단계에서 DB에 데이터를 읽고 쓸 작업에 관한 내용을 코딩 그후 아래 코드처럼 commit or rollback

		try {
			em.persist(Customer.sample());
			Customer customer=em.find(Customer.class, "ID0001");
//			customer.setName("Park");
//			System.out.println(customer.toString());
//			em.remove(customer);
//			Customer customer2=em.find(Customer.class, "ID0002");

			System.out.println(customer.toString());
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

}
