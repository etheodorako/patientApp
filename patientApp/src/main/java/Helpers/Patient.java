package Helpers;

import java.sql.Date;

enum classOfSchool {
	
	A, B, C;
}

public class Patient {
	
	private String schoolID;
	private String name;
	private String surname;
	private Date birth;
	private classOfSchool cl;
	private String tel_father;
	private String tel_mother;
	private String tel_doctor;
	private String mailOfParent;
	private String knownAllergies;
	private String knownHealthIssues;
	private String specialNeeds;
	
	
	public Patient(String schoolID, String name, String surname, Date birth, String cl) {
		super();
		this.schoolID = schoolID;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.cl = classOfSchool.valueOf(cl);
	}
	
	public Patient(String schoolID, String name, String surname, Date birth, String cl, String tel_father,
			String tel_mother, String tel_doctor, String mailOfParent, String knownAllergies, String knownHealthIssues,
			String specialNeeds) {
		super();
		this.schoolID = schoolID;
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.cl = classOfSchool.valueOf(cl);
		this.tel_father = tel_father;
		this.tel_mother = tel_mother;
		this.tel_doctor = tel_doctor;
		this.mailOfParent = mailOfParent;
		this.knownAllergies = knownAllergies;
		this.knownHealthIssues = knownHealthIssues;
		this.specialNeeds = specialNeeds;
	}




	public String getSchoolID() {
		return schoolID;
	}


	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public classOfSchool getCl() {
		return cl;
	}

	public String getClS() {
		return cl.toString();
	}


	public void setCl(classOfSchool cl) {
		this.cl = cl;
	}


	public String getTel_father() {
		return tel_father;
	}


	public void setTel_father(String tel_father) {
		this.tel_father = tel_father;
	}


	public String getTel_mother() {
		return tel_mother;
	}


	public void setTel_mother(String tel_mother) {
		this.tel_mother = tel_mother;
	}


	public String getTel_doctor() {
		return tel_doctor;
	}


	public void setTel_doctor(String tel_doctor) {
		this.tel_doctor = tel_doctor;
	}


	public String getMailOfParent() {
		return mailOfParent;
	}


	public void setMailOfParent(String mailOfParent) {
		this.mailOfParent = mailOfParent;
	}


	public String getKnownAllergies() {
		return knownAllergies;
	}


	public void setKnownAllergies(String knownAllergies) {
		this.knownAllergies = knownAllergies;
	}


	public String getKnownHealthIssues() {
		return knownHealthIssues;
	}


	public void setKnownHealthIssues(String knownHealthIssues) {
		this.knownHealthIssues = knownHealthIssues;
	}


	public String getSpecialNeeds() {
		return specialNeeds;
	}


	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	@Override
	public String toString() {
		return "Patient [schoolID=" + schoolID + ", name=" + name + ", surname=" + surname + ", birth=" + birth
				+ ", cl=" + cl + ", tel_father=" + tel_father + ", tel_mother=" + tel_mother + ", tel_doctor="
				+ tel_doctor + ", mailOfParent=" + mailOfParent + ", knownAllergies=" + knownAllergies
				+ ", knownHealthIssues=" + knownHealthIssues + ", specialNeeds=" + specialNeeds + "]";
	}

	
	
	
}
