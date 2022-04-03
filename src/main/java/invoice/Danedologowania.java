package invoice;

public class Danedologowania {
 int id;
 String login;
 String haslo;
 String typKonta;
 String status;

 Danedologowania(){}
 Danedologowania(int x, String y, String z,String a,String b)
 {
	 this.id=  x;
	 this.login = y;
	 this.haslo = z;
	 this.typKonta = a;
	 this.status = b;
 }
 
 
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getHaslo() {
	return haslo;
}
public void setHaslo(String haslo) {
	this.haslo = haslo;
}
public String getTypKonta() {
	return typKonta;
}
public void setTypKonta(String typKonta) {
	this.typKonta = typKonta;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
