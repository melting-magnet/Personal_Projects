package product.view;

import java.util.ArrayList;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.dto.Product;

public class ProductView {

	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();

	public void displayList(ArrayList<Product> list) {
		for (Product p : list) {
			System.out.println(p.toString());
		}
	}

	public void displayRow(Product product) {
		System.out.println(product.toString());
	}

	public String inputProductName() {
		// : 조회할 상품이름 입력용
		System.out.print("조회 또는 삭제하실 상품 이름 입력: ");
		return sc.next();
	}

	public Product inputProduct() {

		Product p = new Product();

		System.out.println("\n새로운 상품을 입력합니다.");

		System.out.print("제품번호: ");
		p.setProductId(sc.nextLine());
		System.out.print("제품이름: ");
		p.setpName(sc.nextLine());
		System.out.print("제품가격: ");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.print("설명: ");
		p.setDescription(sc.nextLine());

		return p;
	}

	public Product updateProduct() {
		// : 상품아이디에 대한 상품가격 수정 입력용
		Product p = new Product();

		System.out.println("\n상품가격을 수정합니다.");

		System.out.print("제품번호: ");
		p.setProductId(sc.nextLine());
		System.out.print("제품가격: ");
		p.setPrice(sc.nextInt());
		sc.nextLine();

		return p;
	}

	public String inputProductId() {
		// : 조회 또는 삭제할 상품아이디 입력용
		System.out.print("조회 또는 삭제하실 상품 아이디 입력: ");
		return sc.nextLine();

	}

	public void displayError(Exception e) {
		// : 전달받은 예외의 에러메세지 출력
		System.out.println("오류가 발생했습니다. : " + e);
		System.out.println("관리자에게 문의하세요.");
	}

	public void displayMenu() {

		ArrayList<Product> list = null;
		String id = null;
		Product p = null;
		int i = 0;

		do {

			try {
				System.out.println("\n***** 제품조회 페이지 *****");
				System.out.println("1. 전체 조회");
				System.out.println("2. 추가");// : 추가후 id로 조회 확인함
				System.out.println("3. 수정");// : id으로 조회 후 가격 수정함
				System.out.println("4. 삭제");// : id로 조회 후 삭제함
				System.out.println("5. 검색");// : 이름으로 조회함
				System.out.println("6. 끝내기");
				System.out.print("번호 입력: ");
				int no = sc.nextInt();
				sc.nextLine();
				switch (no) {

				case 1:// 완료
					this.displayList(pc.selectAll());
					break;

				case 2: // 완료
					p = this.inputProduct();
					i = pc.insertRow(p);
					if (i > 0) {
						System.out.println("\n성공적으로 추가되었습니다.");
					} else {
						System.out.println("\n추가에 실패하였습니다. 관리자에게 문의하세요.");
					}
					break;

				case 3:
					p = updateProduct();
					i = pc.updateRow(p);
					if (i > 0) {
						System.out.println("\n성공적으로 수정되었습니다.");
					} else {
						System.out.println("\n수정에 실패하였습니다. 관리자에게 문의하세요.");
					}
					this.displayList(pc.selectAll());

					break;
				case 4: // 완료
					id = this.inputProductId();
					i = pc.deleteRow(id);
					if (i > 0) {
						System.out.println("\n성공적으로 삭제되었습니다.");
					} else {
						System.out.println("\n삭제에 실패하였습니다. 관리자에게 문의하세요.");
					}
					this.displayList(pc.selectAll());
					break;
				case 5: // 완료
					String s = this.inputProductName();
					list = pc.selectName(s);
					if (list.size() != 0) {
						this.displayList(list);
					} else {
						System.out.println("\n결과가 없습니다.");
					}

					break;
				case 6:
					System.out.println("정말로 끝내시겠습니까? (Y|N)");
					if (sc.next().toUpperCase().charAt(0) == 'Y') {
						return; // main으로 돌려보내 종료
					} else {
						break;
					}
				default:
					System.out.println("\n잘못 입력하셨습니다.");
					System.out.println("확인하고 다시 입력하세요.");
					break;
				}
			} catch (Exception e) {
				displayError(e);
			}

		} while (true);
	}

}
