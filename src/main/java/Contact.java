/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author brabev04
 */
public class Contact {
	protected long ID;
	protected int phone;
	protected String email;

	public Contact(long ID, int phone, String email) {
		this.ID = ID;
		this.phone = phone;
		this.email = email;
	}

	public Contact(long ID, int phone) {
		this.ID = ID;
		this.phone = phone;
	}

	public Contact(long ID, String email) {
		this.ID = ID;
		this.email = email;
	}

	// pouze zamestnanci maji pristup k temto informacim
	public int getTelefon(Person o) {
		if (o.getClass() != Employee.class) {
			throw new IllegalArgumentException("Person neni zamestnanec");
		}
		return phone;
	}

	public String getEmail(Person o) {
		if (o.getClass() != Employee.class) {
			throw new IllegalArgumentException("Person neni zamestnanec");
		}
		return email;
	}

	public long getID(Person o) {
		if (o.getClass() != Employee.class) {
			throw new IllegalArgumentException("Person neni zamestnanec");
		}
		return ID;
	}

	public void zmenaCisla(int newTelefon) {
		setTelefon(newTelefon);
	}

	public void zmenaEmailu(String newEmail) {
		setEmail(newEmail);
	}

	protected void setTelefon(int phone) {
		// overeni cisla;
		this.phone = phone;
	}

	protected void setEmail(String email) {
		// overeni emailu
		this.email = email;
	}
        
        @Override
        public String toString(){
            if(email!=null && phone!=0){
                return "Email: " + email + " Telfon: " + phone ;
            }
            if(email!= null && phone == 0){
                return "Email: " + email;
            }
            
            
            return "Telefon: " + phone;
        }
}
