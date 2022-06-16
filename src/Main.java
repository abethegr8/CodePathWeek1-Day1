import java.awt.desktop.QuitEvent;

public class Main {
    /*
    Write a function that reverses a string.

    Examples:

    Input: "hello"
    Output: "olleh"
     */
    //Understand: We will always have a string, at N length.
    //Match: Common Pattern, Two Pointer Technique, one pointer at beginning of String and One at the end of string, run while loop, use SWAP
    //Plan: create two integers, name them left starts at 0, right starts at end of string .length - 1; convert string to char array, s.toCharArray();
          //create while loop with conditions (left<right), continue with swaps, create temp char to hold charat left, then swap left with right and tmp with right
          //Loop finishes we convert the chararray back to string, String returnString = new String(newString);
          //because its two pointer N/2 which Time O(N), Space O(N);

    public static String reverseString(String s){
        char[] newString = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            char tmp = newString[left];
            newString[left++] = newString[right];
            newString[right--] = tmp;
        }

        String returnString = new String(newString);

        return returnString;
    }

    public static String reverseStringRecursive(String s){
        if(s.equals("")){
            return "";
        }
        return reverseStringRecursive(s.substring(1)) + s.charAt(0);
    }

    /*
    Write a function that takes in two strings and returns true if the second string is substring of the first, and false otherwise.
    Input: laboratory, rat
    Output: true

    Input: cat, meow
    Output: false
     */
    /*
    1. UnderStand Section:
    Before finishing this section or revealing the solution below, ensure that you have done the following:
    Established a set (2-3) of test cases to verify their own solution later.
    Established a set (1-2) of edge cases to verify their solution handles complexities.
    Have fully understood the problem and have no clarifying questions.
    Have you verified any Time/Space Constraints for this problem?
    Examples of Questions we can ask:
    Are both inputs only Strings?
    Can elements of the Strings be both characters and numbers?
    Can the second string be larger?
    Time and Space consideration -
    Best Case Time Complexity O(N*M)
    Best Case Space Complexity O(1)
        test examples:
        Input: "CATDOG", "ATDO"
        Output: True
        Input: "CATDOG", "ATDOGE"
        Output: False
        Edge Case:       //what happens if we get blank Strings, "", in this case they say return true
        Input: "CATDOG", ""
        Output: True

    2. MATCH:
    Think about matching, common patterns and tricks that could apply to this problem.
    For Strings, common solution patterns include:
        Two Pointer, left right pointer variables, or pointer on each string
        Storing the characters of the String in a hashmap or a set
        Traverse the string with a sliding window

    3. PLAN:
    Loop through the first string for an initial match. If we find one, check that
    match for a full substring match.

    1) Edge Check
    2) Loop through the first string
    3) Find a match to the first character of the second string
    4) While there is a match, loop through both strings in parallel to ensure
        the match
    5) If there is an entire match to the second string, return True (there is a
        substring)
    6) If the match breaks, continue searching the first string for an initial
        character match
    7) If we make it to the end of the first string without a full match, there
        is no substring match -- return False
     */

    public static boolean isSubString(String s, String sub){
        return s.contains(sub);
    }

    //example s=catdog, sub atdo, Time O(N*M), Space O(1)
    public static boolean isSubStringTwo(String s, String sub){
        //edge case, if its just a blank substring, we return true
        if(sub.length() < 1){
            return true;
        }

        //for loop, the i keeps track of the index of the string s
        for (int i = 0; i < s.length(); i++) {
            int indexOfS=i;                     //keeps track of the index of the string
            int j = 0;                          //very clever, keeps track of how many strings we found, if we ever get to the j+1=sub length we found a match
            while(j < sub.length() && indexOfS < s.length() && s.charAt(indexOfS) == s.charAt(j)){      //while loop, with conditions to find a match between s and sub
                j+=1;                           //if we ever go inside the while loop this means we found a match character, increment j
                indexOfS+=1;                    //increment the index of the String, lets see if the next char matches
            }
            if(j + 1 == sub.length()){          //if statement, we found a match if the sub.length every matches j+1. Algorthm should return true
                return true;
            }
        }

        return false;
    }

    //palindrome
    public static boolean isPalindrome(String s){
        //define base case
        if(s.length() == 0 || s.length() == 1){
            return true;
        }

        //do some work to shrink the problem space
        if(s.charAt(0) == s.charAt(s.charAt(s.length() - 1))){
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

    /*
    Given a number, return the next smallest prime number
    Note: A prime number is greater than one and has no other factors other than 1 and itself.
    Examples:
    Input: 3
    Output: 5
    Understand:Is there guaranteed to be a solution? Yes!
    Is the input number guaranteed to be positive? No! This will cause edge case catching important!
    What makes a number prime? What does this number have to satisfy?A prime number only has factors of itself and 1.
    This means 2, 3, 4, 5 … N-1 are not factors of this number
    Input: 5
    Output: 7
    Input: 1
    Output: 2
    EDGE CASE:
    Input: -10
    Output: 2
    The smallest prime number is 2, so any input less than 2 should return 2
    Match: This problem may be hard to match to a specific problem pattern since it relies on general math intuition.
    Plan:Infinitely loop above the input value and check every value after that if it is prime or not.
    1) Iterate from N+1 to INF
    2) If the current number is prime, return this number
    3) Else, continue to increment and re-evaluate the next number
    4) Repeat until we find the next largest prime number, since it is guaranteed to exist
     */

    public static void main(String[] args) {
        String s = "hello";
        String s2 = "racecar";
        //System.out.println("test");
        //System.out.println(reverseString(s));
        System.out.println(reverseStringRecursive(s));
        System.out.println(isPalindrome(s2));
    }

}
