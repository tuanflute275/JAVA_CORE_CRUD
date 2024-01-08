package model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
	private int id;
	private String name;
	private float price;
	private float sale_price;
	private int status;
	private Date expiration_date;

	public Product() {
		
	}

	

	public Product(int id, String name, float price, float sale_price, int status, Date expiration_date) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sale_price = sale_price;
		this.status = status;
		this.expiration_date = expiration_date;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhập vào Tên sản phẩm: ");
		name = sc.nextLine();
		
		try {
			System.out.print("Nhập vào giá sản phẩm: ");
			price = sc.nextFloat();
		} catch (Exception e) {
			System.out.println("Error => Chỉ được nhập vào số.\n");
		}
		sc.nextLine();
		
		try {
			System.out.print("Nhập vào giá khuyến mãi sản phẩm: ");
			sale_price = sc.nextFloat();
		} catch (Exception e) {
			System.out.println("Error => Chỉ được nhập vào số.\n");
		}
		sc.nextLine();
		
		try {
			System.out.print("Nhập vào trạng thái sản phẩm (0 or 1): ");
			status = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Error => Chỉ được nhập vào số.\n");
		}
		sc.nextLine();
		
		try {
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.print("Nhập vào ngày hết hạn: ");
			expiration_date = sf.parse(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Error => Vui lòng nhập đúng định dạng ngày tháng.\n");
		}
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", sale_price=" + sale_price + ", status="
				+ status + ", expiration_date=" + expiration_date + "]";
	}

	

}
