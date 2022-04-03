package invoice;

public class Zawartoscfaktury {
 int id;
 int fakturaId;
 int produktId;
 int ilosc;
 Zawartoscfaktury(){}
 Zawartoscfaktury(int x, int y, int z, int a)
 {
	 this.id=  x;
	 this.fakturaId = y;
	 this.produktId = z;
	 this.ilosc = a;

 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFakturaId() {
	return fakturaId;
}
public void setFakturaId(int fakturaId) {
	this.fakturaId = fakturaId;
}
public int getProduktId() {
	return produktId;
}
public void setProduktId(int produktId) {
	this.produktId = produktId;
}
public int getIlosc() {
	return ilosc;
}
public void setIlosc(int ilosc) {
	this.ilosc = ilosc;
}


}
