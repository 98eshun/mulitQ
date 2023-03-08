package model;

public class GradeDO {

	private String id;
	private int KO;
	private int EN;
	private int MT;
	private int SI;
	
	public GradeDO() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getKO() {
		return KO;
	}

	public void setKO(int kO) {
		KO = kO;
	}

	public int getEN() {
		return EN;
	}

	public void setEN(int eN) {
		EN = eN;
	}

	public int getMT() {
		return MT;
	}

	public void setMT(int mT) {
		MT = mT;
	}

	public int getSI() {
		return SI;
	}

	public void setSI(int sI) {
		SI = sI;
	}
}
