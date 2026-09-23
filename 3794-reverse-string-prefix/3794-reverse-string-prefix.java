class Solution {

    public String reversePrefix(String s, int k) {

        // Convert the string into a character array
        // so that characters can be modified directly.
        char[] characters = s.toCharArray();

        // Reverse only the first k characters.
        for (int leftIndex = 0, rightIndex = k - 1;
             leftIndex < rightIndex;
             leftIndex++, rightIndex--) {

            // Swap the characters at both pointers.
            char temporaryCharacter = characters[leftIndex];
            characters[leftIndex] = characters[rightIndex];
            characters[rightIndex] = temporaryCharacter;
        }

        return new String(characters);
    }
}