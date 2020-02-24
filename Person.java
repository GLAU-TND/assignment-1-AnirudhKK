import java.util.*;
public class Person implements Comparable<Person>
{
	private String firstName;
	private String lastName;
	private ArrayList<String> phoneNumber = new ArrayList<String>();
	private String email;
    public Person(String firstName, String lastName, ArrayList<String> number, String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        phoneNumber=number;
        this.email=email;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public String getEmail()
    {
    return email;
    }
    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addPhoneNumber(String pNumber) {
        phoneNumber.add(pNumber);
    }
    @Override
    public String toString()
    {
        String sen="";
        sen+=("-------- * -------- * -------- * --------");
        sen+=("\nFirst Name: "+firstName);
        sen+=("\nLast Name: "+lastName);
        if(phoneNumber.size()>1)
        {
            sen+=("\nContact Number(s): ");
            for(int i=0;i<phoneNumber.size();i++)
            {
				if(i==0)
					sen+=(""+phoneNumber.get(i));
				else
                sen+=(", "+phoneNumber.get(i));
            }
        }
        else
        {
            sen+=("\nContact Number: ");
                sen+=(phoneNumber.get(0));
        }
        sen+=("\nEmail Address: "+email);
        sen+=("\n-------- * -------- * -------- * --------");
        return sen;
    }
    @Override
    public int compareTo(Person p)
    {
        return this.getFirstName().compareTo(p.getFirstName());
    }
}