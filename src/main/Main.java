package main;

import java.util.List;
import java.util.Scanner;

import dao.impl.ProductDAOImpl;
import model.Product;

public class Main {
	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		do {
			System.out.println("\n=============MENU=============\n");
			System.out.println("1. Thêm mới sản phẩm.");
			System.out.println("2. In danh sách sản phẩm.");
			System.out.println("3. Cập nhật sản phẩm.");
			System.out.println("4. Xóa sản phẩm.");
			System.out.println("5. Lấy sản phẩm theo ID.");
			System.out.println("6. Tìm kiếm theo tên sản phẩm. \n");
			System.out.println("Nhập số 0 để thoát chương trình.");
			System.out.println("Xin mời bạn lựa chọn.\n");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 0:
				System.out.println("Thank you for using the application.");
				break;
			case 1:
				product.input();
				boolean checkInsert = ProductDAOImpl.getInstance().insert(product);
				if (checkInsert) {
					System.out.println("\nSUCCESS ===> Thêm mới sản phẩm thành công.");
				} else {
					System.out.println("\nERROR ===> Thêm mới sản phẩm thất bại.");
				}
				break;
			case 2:
				List<Product> list = ProductDAOImpl.getInstance().selectAll();
				if(list.size() == 0) {
					System.out.println("WARNING  ===> KHÔNG CÓ DỮ LIỆU.");
				}else {
					System.out.println("\t\t\tDANH SÁCH SẢN PHẨM:\n ");
					for (Product pro : list) {
						System.out.println(pro.toString());
					}
				}
				break;
			case 3:
				System.out.print("Nhập ID cần cập nhật: ");
				String idUpdate = sc.nextLine();
				Product dataByIdUpdate = ProductDAOImpl.getInstance().selectById(idUpdate);
				if (dataByIdUpdate == null) {
					System.out.println("Không có sản phẩm nào với Id là: " + idUpdate);
				} else {
					System.out.println(dataByIdUpdate);
					product.input();
					boolean checkUpdate = ProductDAOImpl.getInstance().update(product, idUpdate);
					if (checkUpdate) {
						System.out.println("\nSUCCESS ===>Cập nhật sản phẩm thành công.");
					} else {
						System.out.println("\nERROR ===>Cập nhật sản phẩm thất bại.");
						System.out.println("\nERROR ===>Không có sản phẩm nào với ID là: "+idUpdate);
					}
				}
				break;
			case 4:
				System.out.print("Nhập ID cần xóa: ");
				String idDelete = sc.nextLine();
				boolean checkDelete = ProductDAOImpl.getInstance().delete(idDelete);
				if (checkDelete) {
					System.out.println("\nSUCCESS ===>Xóa sản phẩm thành công.");
				} else {
					System.out.println("\nERROR ===>Xóa sản phẩm thất bại.");
					System.out.println("\nERROR ===>Không có sản phẩm nào với ID là: "+idDelete);
				}
				break;
			case 5:
				System.out.print("Nhập ID cần tìm kiếm: ");
				String idFind = sc.nextLine();
				Product dataById = ProductDAOImpl.getInstance().selectById(idFind);
				if (dataById == null) {
					System.out.println("ERROR ===>Không tìm thấy sản phẩm nào với ID là: " + idFind);
				} else {
					System.out.println("\nKết quả tìm được là: ");
					System.out.println(dataById);
				}
				break;
			case 6:
				System.out.println("Nhập tên cần tìm kiếm: ");
				String valueSearch = sc.nextLine();
				List<Product> listByName = ProductDAOImpl.getInstance().selectByName(valueSearch);
				if(listByName.size() == 0) {
					System.out.println("WARNING  ===> KHÔNG CÓ DỮ LIỆU.");
				}else {
					System.out.println("\t\t\tDANH SÁCH SẢN PHẨM THEO TÊN:\n ");
					for (Product pro : listByName) {
						System.out.println(pro.toString());
					}
				}
				break;

			default:
				System.out.println("Không hợp lệ, vui lòng lựa chọn từ 1 - 5");
				break;
			}
		} while (choice != 0);
	}
}
