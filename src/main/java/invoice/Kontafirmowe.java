package invoice;

public class Kontafirmowe {

 int id;
 String nazwa;
 String nrKonta;
 float balans;

 Kontafirmowe(){}
 Kontafirmowe(int x, String y, String z,float a)
 {
	 this.id=  x;
	 this.nazwa = y;
	 this.nrKonta = z;
	 this.balans = a;
 }
 
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getNrKonta() {
		return nrKonta;
	}
	public void setNrKonta(String nrKonta) {
		this.nrKonta = nrKonta;
	}
	public float getBalans() {
		return balans;
	}
	public void setBalans(float balans) {
		this.balans = balans;
	}

}
