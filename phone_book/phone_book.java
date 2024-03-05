package phone_book;
import java.util.*;

public class phone_book {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иван", "8-900-856-85-55");
        addContact(phoneBook, "Маша", "8-845-623-98-45");
        addContact(phoneBook, "Иван", "8-962-745-85-12");
        addContact(phoneBook, "Леонид", "8-930-965-52-12");
        addContact(phoneBook, "Маша", "8-975-123-65-85");
        addContact(phoneBook, "Маша", "8-986-845-87-96");
        addContact(phoneBook, "Лена", "8-965-745-88-23");

        printPhoneBook(phoneBook);
    }
    
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }
    
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        
        entries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
        
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " тел.");
            for (String number : entry.getValue()) {
                System.out.println("\t" + number);
            }
        }
    }
}
