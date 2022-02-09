// Swastik Singh
// 01/08/2022
// CSE 143 AG
// TA: Omar Ibrahim



// The LetterInventory class is  used to keep track of an inventory of letters 
// of the alphabet. The constructor for the class takes a String and computes how many of 
// each letter are in the String. This is the information the object keeps track of 
// (how many a’s, how many b’s, etc). It ignores the case of the letters 
// and ignores anything that is not an alphabetic character 
// (e.g., it ignores punctuation characters, digits and anything else that is not a letter).
public class LetterInventory{
   private int[] inventory;
   private int size;
   public static final int ALPHABET = 26; // Constant
   
   // Constructs an Inventory (count) of alphabetical letters in
   // a string while ignoring case and nonalphabetical characters
   // It also makes everything lowercase and increases size as required
   public LetterInventory(String data){
      inventory = new int[ALPHABET];
      data = data.toLowerCase();
      for (int i = 0; i < data.length(); i++) {
         if(Character.isLetter(data.charAt(i))) {
            inventory[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }
   
   // Throws an IllegalArgumentException if a nonalphabetic character is passed
   // Sets count for a letter value (ignores case)
   // takes a char as a parameter, to determine the integer inputted
   public int get(char letter){
      if (!Character.isLetter(letter)){
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      return inventory[letter - 'a'];
   }
   
   // throws an IllegalArgumentException if a nonalphabetical character is
   // passed or if the value is negative
   // This method sets the count for the letter inputted at the given value
   // The case for the letter doesn't matter
   public void set(char letter, int value){
      if(!Character.isLetter(letter) || value < 0){
         throw new IllegalArgumentException();
      }
      letter = Character.toLowerCase(letter);
      size -= inventory[letter - 'a'];
      inventory[letter - 'a'] = value;
      size += value;
   }
   
   // Returns the size of the array inventory
   public int size(){
      return size;
   }
   
   // returns true if the array is empty
   // returns false if array isn't empty
   public boolean isEmpty(){
      return size == 0;
   }
   
   // returns String result
   // forms a String (result) of letters (all lowercase) and sorted that represents 
   // the array inventory[]
   public String toString(){
      String result = "[";
      for (int i = 0; i < ALPHABET; i++){
         for(int j = 0; j < inventory[i]; j++){
            result += (char) (i + 'a');
         }
      }
      return result + "]";
   }
   
   // Constructs a new LetterInventory (added) and adds the letter from inventory[i]
   // and another letter from a second LetterInventory
   // returns the new added LetterInventory
   public LetterInventory add(LetterInventory other){
      LetterInventory added = new LetterInventory("");
      for (int i = 0; i < ALPHABET; i++){
         char letter = (char) (i + 'a');
         int value = inventory[i] + other.get(letter);
         added.set(letter, value);
      }
      return added;
   }
   
   // Constructs a new LetterInventory (subtracted) and subtracts the letter from inventory[i]
   // and another letter from a second LetterInventory
   // returns the new subtracted LetterInventory
   public LetterInventory subtract(LetterInventory other){
      LetterInventory subtracted = new LetterInventory("");
      for (int i = 0; i < ALPHABET; i++){
         char letter = (char) (i + 'a');
         int value = inventory[i] - other.get(letter);
         if (value < 0){
            return null;
         }
         subtracted.set(letter, value);
      }
      return subtracted;
   }
}