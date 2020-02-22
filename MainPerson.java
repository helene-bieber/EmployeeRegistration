import java.util.ArrayList;
import java.util.Collections;

class MainPerson{
 
 private ArrayList<Person> personList;
	
	public MainPerson() {
		personList = new ArrayList<>();
	}
	
	public void addPerson(Person p) {
		personList.add(p);
	}
	
	public ArrayList<Person> getPersonList() {
		Collections.sort(personList);
		return personList;
	}

 
 }
    
 