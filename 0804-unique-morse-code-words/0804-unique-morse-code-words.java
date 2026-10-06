class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<String> set = new HashSet<>();

        String xx = "";
        for(String word : words){
            for(int i = 0; i< word.length(); i++){
                char ch = word.charAt(i);
                int idx = alphabet.indexOf(ch);
                xx += morse[idx];
            }
            set.add(xx);
            xx = "";
        }
        return set.size();

    }
}