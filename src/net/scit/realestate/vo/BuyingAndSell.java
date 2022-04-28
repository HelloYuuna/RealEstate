package net.scit.realestate.vo;

/**
 * 매매
 */
public class BuyingAndSell extends RealEstate {
	private int price;

	public BuyingAndSell() {
		super();
	}

	public BuyingAndSell(int price) {
		super();
		this.price = price;
	}

	public BuyingAndSell(String address, String housetype, int size, int price) {
		super(address, housetype, size);
		this.price = price;
	}
	
	@Override
	public String getInfo() {
		return "매매";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return super.toString() + ", 매매가격:" + price + "만 원";
	}
	
}
