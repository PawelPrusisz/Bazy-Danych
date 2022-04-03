package invoice;

public class Produkty {
 int id;
 float cena;
 String nazwa;

 Produkty(){}
 Produkty(int x, float y, String z)
 {
	 this.id=  x;
	 this.cena = y;
	 this.nazwa = z;
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getCena() {
	return cena;
}
public void setCena(float cena) {
	this.cena = cena;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}


}
