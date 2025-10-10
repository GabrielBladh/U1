/*
* Author: <Gabriel Bladh>
* Id: <ar7086>
* Study program: <DT>
*/
import java.util.Scanner;

public class DA339A_U1 {
  static Scanner input = new Scanner(System.in); //can be removed if another solution is used that does not require this scanner-object
  static int passingGradeThreshold = 0; //change as you need when testing      
                                             
  
  // an array to use for testing, replace as needed to test your code
  static String[][] resultsList = {{"Adam Ason", "14","U"},
                                 {"Berta Bson", "25","G"},
                                 {"Ceasar Cson", "17","U"},
                                 {"","",""},
                                 {"Diva Dson","20","G"},
                                 {"","",""},
                                 {"Evert Eson","",""},
                                 {"","",""},
                                 {"","",""},
                                 {"","",""},
                               };

static String[][] tempArray = {{"","","",}};
 /*For testing at presentation do not erase this block
                                {{"Adam Ason", "14","U"},
                                 {"Berta Bson", "25","G"},
                                 {"Ceasar Cson", "17","U"},
                                 {"","",""},
                                 {"Diva Dson","20","G"},
                                 {"","",""},
                                 {"Evert Eson","",""},
                                 {"","",""},
                                 {"","",""},
                                 {"","",""},
                               };                            
 */


 /* Parameters for methods below may NOT be changed and HAVE TO BE USED as intended for a passing grade.*/

  /**
   * This method makes sure to print the information about the persons in the result list 
   * (name, score and grade) from the result list in the terminal for the user. 
   * The print out shall show name, score (if set), grade (if set) and a number representing the person's place in the result list. 
   * Empty places in the result list will NOT be shown.
   */
  public static void printPersonsInformation() 
  {
    System.out.println("You chose to print the information of the persons in the result list"); //you don't need to keep this line
    for (int row = 0; row < resultsList.length; row++)
    {
      for (int col = 0; col < resultsList[row].length; col++)
      {
        if (resultsList[row][col] != "")
        {
          System.out.println(row + 1 + "." + resultsList[row][col]);
        }
      }
      System.out.println();
    }
  }

  /**
   * This method makes sure to print the whole result list in the terminal for the user. 
   * If a place in the result list contains data for a person the person's name, score (if set) and grade (if set) is shown. 
   * If a place in the result list is empty a text stating that the place in empty is shown. 
   * In both cases a number representing the place in the result list is shown.
   */
  public static void printResultList() {
    //System.out.println("You chose to print the result list"); //you don't need to keep this line
    for (int row = 0; row < resultsList.length; row++)
    {
      for (int col = 0; col < resultsList[row].length; col++)
      {
        if (resultsList[row][2] != "")
        {
          System.out.println(row + ". " + resultsList[row][col]);
        }
        else
        {
          System.out.println(row + ". " + "This space is empty");
        }
      }
      System.out.println();
    }
  }

  /**
   * This method makes sure to print statistics about the result list to the user. 
   * The following statistics shall be shown:
   * -	Total number of persons taking the test in the list regardless of whether a score is set or not
   * -	Total number of persons with a passing grade G
   * -	Total number of persons that failed grade U
   * -	The highest score and namne of the person with that score and the given grade
   * -	The lowest score and namne of the person with that score and the given grade
   */
  public static void printStatistics() {
    System.out.println("You chose to print statistics"); //you don't need to keep this line
    int peopleTakingTest = 0;
    int godkändaElever = 0;
    int underkändaElever = 0;
    int elevPoäng = 0;
    int högstPoäng = 0;
    int lägstPoäng = 0;
    int indexRowHigh = 0;
    int indexRowLow = 0;
    for (int row = 0; row < resultsList.length; row++)
    {
      if (resultsList[row][0] != "")
      {
        peopleTakingTest += 1;
      }
      if (resultsList[row][2] == "G")
      {
        godkändaElever += 1;
      }
      if (resultsList[row][2] == "U")
      {
        underkändaElever += 1;
      }
      if (resultsList[row][1] != "")
      {
       elevPoäng = Integer.parseInt(resultsList[row][1]);
        if (row == 0)
        {
          lägstPoäng = elevPoäng;
          högstPoäng = elevPoäng;
        }
        if  (elevPoäng > högstPoäng)
        {
          högstPoäng = elevPoäng;
          indexRowHigh = row;
        }
        if  (lägstPoäng > elevPoäng)
        {
          lägstPoäng = elevPoäng;
          indexRowLow = row;
        }
      }
      else
      {
        continue;
      }
    }
    System.out.println("Så här många elever tar testet: " + peopleTakingTest);
    System.out.println("Så här många elever fick godkänt: " + godkändaElever);
    System.out.println("Så här många elever fick underkänt: " + underkändaElever);
    System.out.println("Högsta poäng har: " + resultsList[indexRowHigh][0] + " " + högstPoäng + " " + resultsList[indexRowHigh][2] + " ");
    System.out.println("Lägst poäng har: " + resultsList[indexRowLow][0] + " " + lägstPoäng +  " " + resultsList[indexRowLow][2]);
  }

  /**
   * This method adds a person to the result list. 
   * The information that is added to the result list is defined in the method parameters. 
   * If a user tries to add a person to a full result list an error messages informing the user 
   * about this will be shown and no person added to the list.
   * @param name The name of the person to add
   * @param score The score of the person to add as an int, if this is a negative value no score is set.
   */
  public static void addPerson(String name, int score) 
  {
    boolean foundEmptySpace = false;
    while (foundEmptySpace == false)
    {
     for (int row = 0; row < resultsList.length; row++)
      {
        if (resultsList[row][0] == "")
        {
          int index = row;
          resultsList[row][0] = name;
          resultsList[row][1] = Integer.toString(score);
          if (resultsList[row][1].equals("-1"))
          {
            resultsList[row][1] = "";
            System.out.println(name + " " + resultsList[row][1]);
          }
          passingGradeThreshold(index);
          System.out.println(name + " " + resultsList[row][1]);
          foundEmptySpace = true;
        }
      }
    }
  }

  /**
   * This method changes the name of a specific person in the result list. 
   * Which persons's name is changed is decided by a method parameter. 
   * If a user tries to change the name at a place in the list that has 
   * no current person an error message informing the user about this 
   * will be shown and no data in the result list is changed.
   * @param index The index of the person whose name shall be changed.
   * @param newName The new name of the person at place given by index.
   */
  public static void changeNameOfPerson(int index, String newName) {
    resultsList[index][0] = newName;
    System.out.println("The new name of row " + index + " is " + newName);    
  }

  /**
   * This method changes the score for a specific person in the result list. 
   * Which person's score is changed is decided by a method parameter. 
   * If a user tries to change the score at a place in the list that has 
   * no current person an error message informing the user about this 
   * will be shown and no data in the result list is changed.
   * @param index The index of the person whose score shall be changed.
   * @param newScore The new score, as an int, of the person at place given by index. If this is a negative value no score is set.
   */
  public static void changeScoreForPerson(int index, int newScore) 
  {
    if (newScore == -1)
    {
      resultsList[index][1] = "";
      System.out.println("The new score of row " + resultsList[index][0] + " is " + newScore);
    }
    else
    {
      resultsList[index][1] = Integer.toString(newScore);
      passingGradeThreshold(index);
      System.out.println("The new score of row " + resultsList[index][0] + " is " + newScore);
    }
    //main(null);
  }

  /**
   * This method removes a person at a given index from the result list. 
   * The data at this index is replaced by empty Strings. 
   * If no person exists at the given index an error message informing 
   * the user about this will be shown and no data in the result list is changed.
   * @param index The index of the place where a person is to be removed.
   */
  public static void removePerson(int index) {
    int row = 0;
    if (resultsList[index][0] != "")
    {
      System.out.println("Deleting index: " + index + "...");
      for (int col2 = 0; col2 < resultsList[row].length; col2++)
      {
        resultsList[index][col2] = "";
      }
    }
    else 
    {
      System.out.println("This index is empty, sending you back to menu");
    }
  }

  /**
   * This method changes places in the result list for the data existing 
   * at those places given by the parameters. It is possible to change 
   * places between data even if one or both places contains empty strings. 
   * This gives the user the possibility to change the place of one person 
   * to an empty place in the result list.  
   * If the two parameters have the same value an error message informing 
   * the user about this will be shown and no data in the result list is changed.
   * @param index1 First index involved in the change of places
   * @param index2 Second index involved in the change of places
   */
  public static void changePlaces(int index1, int index2) 
  {
    System.out.println("You chose to switch places of index " + index1 + " and " + index2);
    if (index1 != index2 && resultsList[index1][0] != "" && resultsList[index2][0] != "") //Kollar så att vi inte väljer samma person 2 gånger och så vi inte väljer två tomma platser
      {
        for (int col2 = 0; col2 < resultsList[0].length; col2++)
        {
          tempArray[0][col2] = resultsList[index1][col2];
          resultsList[index1][col2] = resultsList[index2][col2];
          resultsList[index2][col2] = tempArray[0][col2];
        }
      }
    else
    {
      System.out.println("You chose two empty spaces or the same person twice, sending you back to menu");
    }
  }

  /**
   * This method prints the program menu in the terminal for the user to view.
   * This printout shall also inform the user about the threshold for a passing grade
   * stored in variable passingGradeThreshold.
   */
  public static void printMenu() 
  {
    System.out.println("Program menu"); //you don't need to keep this line
    System.out.println("1. Information of the persons in the results list");
    System.out.println("2. Print out results list");
    System.out.println("3. Print out statistics");
    System.out.println("4. Add a person");
    System.out.println("5. Change name of person");
    System.out.println("6. Change score of person");
    System.out.println("7. Change place of 2 people");
    System.out.println("8. Remove a person");
    System.out.println("-1. Close system");
  }

  public static int passingGradeThreshold(int index)
  {
    if (resultsList[index][1] != "")
    {
      if (passingGradeThreshold > Integer.parseInt(resultsList[index][1]))
      {
        resultsList[index][2] = "U";
      }
      else 
      {
        resultsList[index][2] = "G";
      } 
    }
    return index;
  }

  public static void scoreForPassing(int passingGradeThreshold)
  {
      for (int row = 0; row < resultsList.length; row++)
      {
        if (resultsList[row][1] != "")
         {
          if (passingGradeThreshold > Integer.parseInt(resultsList[row][1]))
          {
            resultsList[row][2] = "U";
          }
          else 
          {
            resultsList[row][2] = "G";
          }  
        }
      } 
  }
  /**
   * This method reads the menu choice from the user and returns the choice the user made as an integer.
   * @return The menu choice made by the user represented by an integer value of type int.
   */
  public static int readMenuChoice() {
    System.out.println("Make menu choice"); //you don't need to keep this line
    int Val = 0;
    while (!input.hasNextInt() || (Val = input.nextInt()) > 8 || Val == 0 || Val < -2)
    {
      input.nextLine();
      System.out.println("Please enter a valid input");
    }
    return Val; //line can be removed later if needed, needed like this to compile the code template
  }

  public static int isInputInt()
  {
    int isInt = 0;
    while (!input.hasNextInt() || (isInt = input.nextInt()) < -1)
    {
      input.nextLine();
      System.out.println("Please enter a valid input");
    }
    return isInt;
  }

  public static int isInputValid()
  {
    int isValid = 0;
    while (!input.hasNextInt() || (isValid = input.nextInt()) > 9 || isValid < 0)
    {
      input.nextLine();
      System.out.println("Please enter a valid input");
    }
    return isValid;
  }
  


  public static void main(String[] args) {
    System.out.println("What is the score for passing this test?");
    passingGradeThreshold = input.nextInt();
    scoreForPassing(passingGradeThreshold);
    boolean x = true;
    while (x == true)
    { 
      printMenu();
      int menyVal = readMenuChoice();
      System.out.println(menyVal);
      if (menyVal == 1)
      {
        printPersonsInformation();
      }
      if (menyVal == 2)
      {
        printResultList();
      }  
      if (menyVal == 3)
      {
        printStatistics();
      }
      if (menyVal == 4) //addPerson
      {
        if (resultsList[9][0] != "")
        {
          System.out.println("All spaces are filled already");
        }
        else 
        {
          System.out.println("You chose to add a person");
          System.out.println("Name of the new person you want to add");
          input.nextLine();
          String name = input.nextLine();
          System.out.println("Score of the new person, read -1 if you dont want to add a score");
          int score = isInputInt();
          addPerson(name, score);
        }
      }
      if (menyVal == 5) //changeNameOfPerson
      {
        System.out.println("You chose to change the name of a person"); //you don't need to keep this line
        for (int row = 0; row < resultsList.length; row++)
        {
          System.out.println(row + "." + resultsList[row][0]);
        }
        System.out.println("Choose the person that you want to change by chosing their number on the list");
        int index = isInputValid();
        if (resultsList[index][0] != "")
        {
          System.out.println("What is the new name of this person?");
          input.nextLine();
          String newName = input.nextLine();
          changeNameOfPerson(index, newName);
        }
        else
        {
          System.out.println("This space is already empty, taking you back to the menu");
        }
      }
      if (menyVal == 6) //changeScoreForPerson
      {
        System.out.println("You chose to change the score of a person"); //you don't need to keep this line
        System.out.println("Choose the person that you want to change by chosing their number on the list");
        for (int row = 0; row < resultsList.length; row++)
        {
          for (int col = 0; col < resultsList[row].length; col++)
          {
            System.out.println(row + "." + resultsList[row][col]);
          }
        }
        int index = isInputValid();
        if (resultsList[index][0] != "")
        {
          System.out.println("What is the new score of " + resultsList[index][0] + "?" + " Choose -1 if they shouldn't have a new score");
          input.nextLine();
          int newScore = isInputInt();
          changeScoreForPerson(index, newScore);
        }
        else 
        {
          System.out.println("There is no person on this index, taking you back to menu");
        }
      }
      if (menyVal == 7) //changePlaces
      {
        System.out.println("You chose to switch places of a person(s)"); //you don't need to keep this line
        System.out.println("Choose which people you want to change by chosing their number on the list");
        for (int row = 0; row < resultsList.length; row++)
        {
          for (int col = 0; col < resultsList[row].length; col++)
          {
            System.out.println(row + "." + resultsList[row][col]);
          }
        }
        System.out.println("Choose the first person, or an empty space");
        int index1 = isInputValid();
        System.out.println("Choose the next person, or an empty space" + "\n" + "NOTE: YOU CAN NOT CHOOSE EMPTY SPACE TWICE NEITHER CAN THE SAME PERSON BE CHOSEN TWICE");
        int index2 = isInputValid();
        changePlaces(index1, index2);
      }
      if (menyVal == 8) //removePerson
      {
        System.out.println("You chose to remove a person"); //you don't need to keep this line
        System.out.println("Choose which person you want to delete by chosing their number on the list");
        for (int row = 0; row < resultsList.length; row++)
        {
          for (int col = 0; col < resultsList[row].length; col++)
          {
            System.out.println(row + "." + resultsList[row][col]);
          }
        }
        int index = isInputValid();
          removePerson(index);
      }
      if (menyVal == -1)
      {
        x = false;
      }
    }
     // Do not forget to read the threshold of the passing grade as the program starts 
     // and store it in the variable passingGradeThreshold.
  }
}
