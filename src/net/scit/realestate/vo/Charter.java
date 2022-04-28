package net.scit.realestate.vo;

/**
 * 전세
 */
@SuppressWarnings("SpellCheckingInspection")
public class Charter extends RealEstate {
	
	private int depositMoney;

	public Charter() {
		super();
	}

	public Charter(int depositMoney) {
		super();
		this.depositMoney = depositMoney;
	}

	public Charter(String address, String housetype, int size, int depositMoney) {
		super(address, housetype, size);
		this.depositMoney = depositMoney;
	}
	
	@Override
	public String getInfo() {
		return "전세";
	}

	public int getDepositMoney() {
		return depositMoney;
	}

	public void setDepositMoney(int depositMoney) {
		this.depositMoney = depositMoney;
	}

	@Override
	public String toString() {

		return super.toString() + ", 전세보증금:" + depositMoney + "만 원";
	}
	
}
