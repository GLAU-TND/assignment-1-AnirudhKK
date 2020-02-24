import java.util.*;
import java.util.regex.*;
public class MyMain
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        MyContacts ContactList = new MyContacts();
        int cont=1;
        while(cont==1)
        {
            System.out.println("\nWelcome to DBC's Contact List App\nPress 1 to add a new contact\nPress 2 to view all contacts\nPress 3 to search for a contact\nPress 4 to delete a contact\nPress 5 to exit program\n");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                        System.out.println("You have chosen to add a new contact: ");
                        System.out.println("Please enter the name of the Person");
                        System.out.print("First name: ");
                        String fn=sc.next();
                        System.out.println("");
                        System.out.print("Last name: ");
                        String ln=sc.next();
                        System.out.println("");
                        ArrayList<String> temp = new ArrayList<String>();
                        System.out.print("Contact Number: ");
                        String numberHere=sc.next();
                        String regxMobile="(\\+91|0)?\\d(6789)?\\w{9}";
                        while(Pattern.compile(regxMobile).matcher(numberHere).matches()!=true)
                        {
                            System.out.println("Wrong number entered! Try again!");
                            numberHere=sc.next();
                        }
                        temp.add(numberHere);
                        while(true)
                        {
                            System.out.print("Would you like to add another contact number? (y/n): ");
                            char c=sc.next().charAt(0);
                            if(c=='y')
                            {
                                System.out.print("Contact Number: ");
                                numberHere=sc.next();
                                while(Pattern.compile(regxMobile).matcher(numberHere).matches()!=true)
                                {
                                    System.out.println("Wrong mobile number entered! Try again!");
                                    numberHere=sc.next();
                                }
                                temp.add(numberHere);

                            }
							else if(c=='n')
								break;
							else
							{
								System.out.println("Enter correct choice (y/n)!");
								continue;
							}
						}
                        System.out.println("");
                        System.out.print("Email: ");
                        String e=sc.next();
                        String regxEmail="\\w+\\.*@\\w+\\.\\w+";
                        while(Pattern.compile(regxEmail).matcher(e).matches()!=true)
                        {
                            System.out.println("Invalid email! Try again: ");
                            e=sc.next();
                        }
                        Person p=new Person(fn, ln, temp, e);
                        ContactList.addNewContact(p);
                        Collections.sort(ContactList.list);
                        break;
                case 2:
						if(ContactList.list.size()==0)
							System.out.println("Contact list empty!");
						else
							ContactList.viewAllContacts();
                        break;
                case 3:
                            System.out.print("Enter name to search: ");
                            sc.nextLine();
                            String nameToFind=sc.nextLine();
                            ContactList.searchContact(nameToFind);
                            break;
                case 4:
							if(ContactList.list.size()==0)
								System.out.println("Nothing to delete!");
							else
							{
								System.out.println("Here are all your contacts: ");
								for(int i=0;i<ContactList.list.size();i++)
								{
									System.out.println(""+(i+1)+". "+ContactList.list.get(i).getFirstName());
								}
								System.out.print("Press the number against the contact to delete it: ");
								int del=sc.nextInt();
								while(del>ContactList.list.size())
								{
									System.out.println("Enter correct option!");
									del=sc.nextInt();
								}
								ContactList.deleteContact(del-1);
							}
                            break;
                case 5:
                            cont=0;
                            System.out.println("Thank You for Using Anirudh's Contact App!");
                            break;
                default:
                            System.out.println("Wrong choice entered. Try again!");

            }
    }
}
}