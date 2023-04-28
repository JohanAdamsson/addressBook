import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Person> contacts;
    private Scanner scanner;

    public AddressBook() {
    contacts = new ArrayList<>();
    scanner = new Scanner(System.in);
    }

    public String getFirstName(){
        String firstName;
        do {
            System.out.println("Enter first name, no digits: ");
            firstName = scanner.nextLine();
        } while (!firstName.matches("[a-zA-ZåäöÅÄÖ]+"));
        return firstName;
    }

    public String getFamilyName(){
        String familyName;
        do {
            System.out.println("Enter family name, no digits: ");
            familyName = scanner.nextLine();
        } while (!familyName.matches("[a-zA-ZåäöÅÄÖ]+"));
        return familyName;
    }

    public String getPhoneNumber(){
        String phone;
        do {
            System.out.println("Enter phone number, digits only: ");
            phone = scanner.nextLine();
        } while (!phone.matches("\\d+"));
        return phone;
    }

    public String getStreetAddress(){
        String streetAddress;
        do {
            System.out.println("Enter streetAddress, only digits and characters: ");
            streetAddress = scanner.nextLine();
        } while (!streetAddress.matches("[a-zA-ZåäöÅÄÖ\\d ]+"));
        return streetAddress;
    }

    public String getCity(){
        String city;
        do {
            System.out.println("Enter city, no digits: ");
            city = scanner.nextLine();
        } while (!city.matches("[a-zA-ZåäöÅÄÖ]+"));
        return city;
    }

    public String getZipCode(){
        String zipCode;
        do {
            System.out.println("Enter zip, 5 digits: ");
            zipCode = scanner.nextLine();
        } while (!zipCode.matches("\\d+") || zipCode.length()<5 || zipCode.length()>5);
        return zipCode;
    }

    public void addContact() {
        String firstName = getFirstName();
        String familyName = getFamilyName();
        String phone = getPhoneNumber();
        String streetAddress = getStreetAddress();
        String city = getCity();
        String zipCode = getZipCode();

        Person person = new Person(firstName, familyName, phone, streetAddress, city, zipCode);
        contacts.add(person);
        System.out.println("Contact added: " + person);
    }

    public void removeContact() {
        String first = getFirstName();
        String family = getFamilyName();

        for (int i = 0; i < contacts.size(); i++) {
            if ((contacts.get(i).getFirstName().equalsIgnoreCase(first)) && (contacts.get(i).getFamilyName().equalsIgnoreCase(family))) {
                Person removed = contacts.remove(i);
                System.out.println(String.format("Contact removed: %1$s %2$s",first, family));
                return;
            }
        }
        System.out.println(String.format("Contact not found: %1$s %2$s",first, family));
    }

    public void updateContact() {
        String first = getFirstName();
        String family = getFamilyName();

        for (Person contact : contacts) {
            if ((contact.getFirstName().equalsIgnoreCase(first)) && (contact.getFamilyName().equalsIgnoreCase(family))){
                String phone = getPhoneNumber();
                contact.setPhone(phone);
                String streetAddress = getStreetAddress();
                contact.setStreetAddress(streetAddress);
                String city = getCity();
                contact.setCity(city);
                String zipCode = getZipCode();
                contact.setZipCode(zipCode);

                System.out.println(String.format("Contact updated: %1$s %2$s",first, family));
                return;
            }
        }
        System.out.println(String.format("Contact not found: %1$s %2$s",first, family));
    }

    public void searchContacts() {
        System.out.println("Enter name, address or phone number: ");
        String answer = scanner.nextLine();
        int num = 0;

        for (Person contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(answer) || contact.getFamilyName().equalsIgnoreCase(answer)
                    ||contact.getPhone().equalsIgnoreCase(answer) ||  contact.getStreetAddress().equalsIgnoreCase(answer)
                    || contact.getCity().equalsIgnoreCase(answer) || contact.getZipCode().equalsIgnoreCase(answer)) {
                System.out.println("Contact found: " + contact);
                num++;
            }
        }
        if (num == 0){
            System.out.println("Contact not found: " + answer);
        }
    }

    public void listContacts() {
        System.out.println("\nAddress Book:");
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Update contact");
            System.out.println("4. Search contacts");
            System.out.println("5. List all contacts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addressBook.addContact();
                    break;
                case "2":
                    addressBook.removeContact();
                    break;
                case "3":
                    addressBook.updateContact();
                    break;
                case "4":
                    addressBook.searchContacts();
                    break;
                case "5":
                    addressBook.listContacts();
                    break;
                case "6":
                    addressBook.close();
                    System.out.println("Thanks for trying my address book");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (!choice.equals("6"));
    }
}