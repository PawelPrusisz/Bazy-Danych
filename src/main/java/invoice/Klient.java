package invoice;

public class Klient {
 int logowanieId;
 String imie;
 String nazwisko;
 String nip;
 String telefon;
 String email;
 
 
 Klient(){}
 Klient(int x, String y, String z,String a,String b,String c)
 {
	 this.logowanieId=  x;
	 this.imie = y;
	 this.nazwisko = z;
	 this.nip = a;
	 this.telefon = b;
	 this.email = c;
 }
public int getLogowanieId() {
	return logowanieId;
}
public void setLogowanieId(int logowanieId) {
	this.logowanieId = logowanieId;
}
public String getImie() {
	return imie;
}
public void setImie(String imie) {
	this.imie = imie;
}
public String getNazwisko() {
	return nazwisko;
}
public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public String getNip() {
	return nip;
}
public void setNip(String nip) {
	this.nip = nip;
}
public String getTelefon() {
	return telefon;
}
public void setTelefon(String telefon) {
	this.telefon = telefon;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
