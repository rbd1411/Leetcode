class Solution {
    public int maxRepeating(String sequence, String word) {
        //Base Case
        if(word.length()>sequence.length()) {
            return 0; 
        }

        int count = 0;
        StringBuilder sb = new StringBuilder(word); //Initialize sb with word
        while(sequence.contains(sb.toString())) {
            count++; //Increase count until sequence contains sb
            sb.append(word); //If sequence contains sb add one more word into sb
        }
        return count;
    }
}