/*
Title: Tommorrow's Date
@author: Seow Hui Yin
Date: 25/02/2018
File Name: AsgmtQ1.java

Purpose: The purpose of this program is to calculate the
date following a given date.

Input: The user is required to enter date for day,month and year.

Output: The program will prompt the user for the input and
will display tomorrow's date for the input date. The program
will then ask the user whether wish to continue and loop until user answer NO.
 */

import java.util.Scanner;

public class AsgmtQ1 {
    
 public static void main(String[] argv)
    {
        studentInfo();
        int day, month, year;
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        char option;
        boolean leapYear = false;

        System.out.println("Tomorrow's date: ");
        System.out.print("Enter the day for today's date: "); //Prompt user to enter day
        day = keyboard.nextInt();
        System.out.print("Enter the month for today's date: "); //Prompt user to enter month
        month = keyboard.nextInt();
        System.out.print("Enter the year for today's date: "); //Prompt user to enter year
        year = keyboard.nextInt();
                
        while (true)
        {
          if (isValidDate(day, month, year)) // check if is valid date 
          {
             String nextDate = getNextDate(day, month, year);
             System.out.println("Tomorrow's date is " + nextDate);
          }
          else
          {
             System.out.println("***ERROR: Invalid input - this is not a legal date.");
          }
          
              System.out.println(" ");
              System.out.println("Do you wish to continue(Y/N)");
              keyboard.nextLine();
              userInput = keyboard.nextLine(); //read what is typing
              option = userInput.charAt(0); //extract first character
              
              //Perform option 
              while (option != 'n' && option != 'N')
              {
                 if (option == 'y' || option == 'Y')
                 {
                    System.out.println(" ");
                    System.out.println("Tomorrow's date: ");
                    System.out.print("Enter the day for today's date: ");
                    day = keyboard.nextInt();
                    System.out.print("Enter the month for today's date: ");
                    month = keyboard.nextInt();
                    System.out.print("Enter the year for today's date: ");
                    year = keyboard.nextInt();
                      while (true)
                      {
                       if (isValidDate(day, month, year))
                        {
                          String nextDate = getNextDate(day, month, year);
                          System.out.println("Tomorrow's date is " + nextDate); //Display tomorrow's date
                          break;
                        }
                       else
                        {
                           System.out.println("***ERROR: Invalid input - this is not a legal date.");
                           break;
                        }
                      }
                  }
               
                    {  //Ask for next option   
                    System.out.println(" ");
                    System.out.println("Do you wish to continue(Y/N)");
                    keyboard.nextLine();
                    userInput = keyboard.nextLine();
                    option = userInput.charAt(0);
                    }   
              }
             // user input N,exit loop
             System.out.println("End of program.");
                break;
            
        }

    } 
 
 //Method to calculate tomorrow's date
 public static String getNextDate(int day, int month, int year) 
 {    
  //Month that has 31 days
    if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))   
        {   
       day= thirtyOneDaysMonth(day); //Declare month that have only 31 days
            if(day==1 && month==12)
            {          
                ++year;    
                month=1;    
            }
            else if(day==1 && month!=12)  
            {
                ++month;       
            }

        }

   //Month that has 30 days
         else if ((month==2 || month == 4 || month == 6 || month == 9 || month == 11))     
        {
            day= thirtyDaysMonth(day); //Declare month that has only 30 days
              if(day==1 && month==12)
                {          
                  ++year;                       
                  month=1;                      
                }
              
              else if(day==1 && month!=12)  
                {
                  ++month;       
                }
              
                else if(month==2 && isLeapYear(year)) //Declare 29 day in February & is leap year    
                {
                    if(day>29)                          
                    {
                        ++month;                       
                        day=1;                         
                    }  
                }
                
                else if( day>28 && month==2) //Declare 28 day in February           
                    {
                        ++month;                            
                        day=1;                             
                    }
                
                else                           
                {
                    if(day==1)                       
                    {
                        ++month;                            
                        day=1;                             
                    }
                }
        }
    
      {
         String monthString = ""; //Return name of month from int
        switch (month) {
         case 1 : monthString = "January" ;
             break;
         case 2 : monthString = "February" ;
             break;
         case 3 : monthString = "March" ;
             break;
         case 4 : monthString = "April" ;
             break;
         case 5 : monthString = "May" ;
             break;
         case 6 : monthString = "June" ;
             break;
         case 7 : monthString = "July" ;
             break;
         case 8 : monthString = "August" ;
             break;
         case 9 : monthString = "September" ;
             break;
         case 10 : monthString = "October" ;
             break;
         case 11 : monthString = "November" ;
             break;
         case 12 : monthString = "December" ;
             break;
        }
        
        {
         return (day + " " + monthString + " " + year);
        }
      }

 }
 
 //Method to check leap year
    public static boolean isLeapYear(int year) 
    {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
 
 //Method to declare 30 days in a month 
    public static int thirtyOneDaysMonth(int day) 
    {
        if(day==31)                              
            day=1;
        else 
            ++day;                              
        return day;
    }
    
      {
        if (day > 31)
        System.out.println("***ERROR: Invalid input - this is not a legal date."); 
      }

 //Method to declare 30 days in a month    
    public static int thirtyDaysMonth(int day) 
    {
        if(day==30)  
            day=1;
        
        else
        
            ++day;  
        return day;
    }
      {
       if (day > 30)
       System.out.println("***ERROR: Invalid input - this is not a legal date."); 
      }

//Method to check true or flase for day,month,year
public static boolean isValidDate(int day, int month, int year)  
{
   if (day < 1 || day > 31 || month < 1 || month > 12 || year <= 0)
      return false;
   if((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0))
       return true;
   if (day >28 && month == 2) 
       return false;
   return !(day >29 && month == 2 && isLeapYear(year)); 
}

//Display student information
public static void studentInfo() 
    {
        System.out.println("Name:Seow Hui Yin");
        System.out.println("Student number:33255186");
        System.out.println("Mode of enrolment:External");
        System.out.println("Tutor name:Mr.Chong");
        System.out.println("Tutorial attendance day:Tuesday");
        System.out.println("Time:8.30pm to 10.30pm");
        System.out.println(" ");
    }
}
