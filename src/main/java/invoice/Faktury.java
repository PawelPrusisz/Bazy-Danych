package invoice;

public class Faktury {
 int id;
 int klientId;
 int kontoId;
 
 
 
 Faktury(){}
 Faktury(int x,int y, int z)
 {
	 this.id=  x;
	 this.klientId = y;
	 this.kontoId = z;
 }
 
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getKlientId() {
	return klientId;
}
public void setKlientId(int klientId) {
	this.klientId = klientId;
}
public int getKontoId() {
	return kontoId;
}
public void setKontoId(int kontoId) {
	this.kontoId = kontoId;
}
public int id() {
	return id;
}
public int kontoId() {
	return kontoId;
}
public int klientId() {
	return klientId;
}


}
