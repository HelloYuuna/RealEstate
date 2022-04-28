package net.scit.realestate.vo;

/**
 * 상속용 최상위 클래스
 */
@SuppressWarnings("ALL")
public class RealEstate {
	
	private String address;
	private String housetype;
	private int size;
	
	public RealEstate() {

	}

	public RealEstate(String address, String housetype, int size) {
		this.address = address;
		this.housetype = housetype;
		this.size = size;
	}
	
	public String getInfo(){
		return " ";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHousetype() {
		return housetype;
	}

	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "주소:" + address + ", 주거형태:" + housetype + ", 크기:" + size + "(평)";
	}
	
}
