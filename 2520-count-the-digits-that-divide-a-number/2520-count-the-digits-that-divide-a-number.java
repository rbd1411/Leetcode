class Solution {
    public int countDigits(int num) {
        String str = Integer.toString(num);

    // Initialize a count to keep track of the number of digits that divide num
    int count = 0;

    // Iterate through the digits in the string
    for (int i = 0; i < str.length(); i++) {
      // Convert the current character to an integer
      int digit = Character.getNumericValue(str.charAt(i));

      // Check if the digit divides num
      if (num % digit == 0) {
        // If it does, increment the count
        count++;
      }
    }

    // Return the count
    return count;
    }
}