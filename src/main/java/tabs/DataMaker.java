package tabs;

import invoice.*;

import java.util.ArrayList;
import java.util.List;

import Procedures.*;
public class DataMaker {
   
  
	public ArrayList<ArrayList<ArrayList<Object>>> printData(int klientid){
    	DatabaseConnector connector = DatabaseConnector.getInstance();
    	
        //System.out.println(connector.getZawartosc2(2).get(1).getFakturaId());
    	
    
    	Object[][][] data;
    	
     	
     	ArrayList<Faktury> faktury = (ArrayList<Faktury>) connector.getFaktury2(klientid);
     	ArrayList<ArrayList<ArrayList<Object>>> ans = new ArrayList<ArrayList<ArrayList<Object>>>();
	    for(Faktury f: faktury) 
	    {
	    	int fakturaid = f.getId();
	    	int ilosc;
	     	float cena;
	     	String nazwa;
	     	ArrayList<ArrayList<Object>> cur = new ArrayList<ArrayList<Object>>();
	     	if(f.getKlientId() == klientid) {
	     		System.out.println(fakturaid);
	     		ArrayList<Zawartoscfaktury> list = (ArrayList<Zawartoscfaktury>) connector.getZawartosc2(fakturaid);
	     		
	         	for(Zawartoscfaktury s: list) 
	         	{
	         		ArrayList<Object> XD = new ArrayList<Object>();
	         		ilosc = s.getIlosc();
	         		cena = connector.getProdukty(s.getProduktId()).getCena();
	         		nazwa = connector.getProdukty(s.getProduktId()).getNazwa();
	         		XD.add(nazwa);
	         		XD.add(cena);
	         		XD.add(ilosc);
	         		
	         		//System.out.println("Nazwa: " + nazwa);
	         		
	         		//System.out.println("Cena: " + cena + 
	         		//				  " Ilosc: " + ilosc);
	         		//System.out.println("------------------------");    
	         		cur.add(XD);
	         	}
	         	
	         	ans.add(cur);
	     	}	
	     }
	    /*
	    for(ArrayList<ArrayList<Object>> e : ans)
	    {
	    	for(ArrayList<Object> e2 : e)
	    	{
	    		for(Object o : e2)
	    		{
	    			System.out.print(o.toString() + " ");
	    		}
	    		System.out.println("---");
	    	}
	    	System.out.println("-----XD-----");
	    }
	    */
		return ans;
         	
	}
	
	
    public static void main(String[] args) {
    	/*
    	ArrayList<ArrayList<ArrayList<Object>>> data = printData(1);    
    	for(ArrayList<ArrayList<Object>> e : data)
	    {
    		Object[][] tab = new Object[3000][3];
    		int it = 0;
	    	for(ArrayList<Object> e2 : e)
	    	{
	    		it ++;
	    		Object[] tmp = new Object[3];
	    		for(int i = 0; i < 3; i++)
	    		{
	    			tmp[i] = e2.get(i);
	    			System.out.print(e2.toString());
	    		}
	    		tab[it] = tmp;
	    		System.out.println();
	    	}
	    	Tables tmp = ////;
	    	System.out.println("-----XD-----");
	    }
	    */
    }


}
