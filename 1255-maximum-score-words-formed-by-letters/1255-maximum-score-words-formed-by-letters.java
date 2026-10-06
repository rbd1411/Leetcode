class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int frq[]=new int[26];
        for(char ch:letters){
            frq[ch-'a']++;
        }
        return dfs(words,frq,score,0);
    }
    public int dfs(String words[],int frq[],int score[],int index){
        if(index==words.length){
            return 0;
        }
        int notConsider=dfs(words,frq,score,index+1);
        boolean isPossible=true;
        int wordScore=0;
        String s=words[index];
        for(char ch:s.toCharArray()){
            frq[ch-'a']--;
            wordScore+=score[ch-'a'];
            if(frq[ch-'a']<0){
                isPossible=false;
            }
        }
        int possible=0;
        if(isPossible){
            possible=wordScore+dfs(words,frq,score,index+1);
        }
        for(char ch:s.toCharArray()){
            frq[ch-'a']++;
        }
        return Math.max(possible,notConsider);
    }
}