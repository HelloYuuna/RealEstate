package net.scit.realestate.vo;

/**
 * 월세
 */
@SuppressWarnings("SpellCheckingInspection")
public class MonthlyRent extends RealEstate {
	private int monthlyRent;

	public MonthlyRent() {
		super();
	}

	public MonthlyRent(int monthlyRent) {
		super();
		this.monthlyRent = monthlyRent;
	}

	public MonthlyRent(String address, String housetype, int size, int monthlyRent) {
		super(address, housetype, size);
		this.monthlyRent = monthlyRent;
	}
	
	@Override
	public String getInfo() {
		return "월세";
	}
	
	public int getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	@Override
	public String toString() {
		return super.toString() + ", 월세:" + monthlyRent + "만 원";
	}

}
