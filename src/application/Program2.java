package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
		
		System.out.println("=== TEST 1: Department finbById ===");
		Department depart = departmentDao.findById(2);
		System.out.println(depart);
		
		System.out.println("\n=== TEST 2: Department finbAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New ID = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department Update ===");
		depart = departmentDao.findById(1);
		depart.setName("Food");
		departmentDao.update(depart);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
	}

}
