import java.util.*;
public class MyContacts
{
    public ArrayList<Person> list = new ArrayList<Person>();
    public void addNewContact(Person p)
    {
        list.add(p);
    }
    public void viewAllContacts()
    {
        System.out.println("---Here are all your contacts---");
        for(Person per:list)
        {
            System.out.println(per);
        }
    }
    public void searchContact(String nameToSearch)
    {
        int match=0;
        for(Person per:list)
        {
            if(per.getFirstName().equalsIgnoreCase(nameToSearch))
            {
                match++;
                System.out.println(per);
            }
        }
        if(match==0)
            System.out.println("NO RESULTS FOUND!");
        else
            System.out.println(match+ " match found!");
    }
    public void deleteContact(int index)
    {
        System.out.println(""+list.get(index).getFirstName()+"'s contact deleted!\n");
        list.remove(index);
    }

}