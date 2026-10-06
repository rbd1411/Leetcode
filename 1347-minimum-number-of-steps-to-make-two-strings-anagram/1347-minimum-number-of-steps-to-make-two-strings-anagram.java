class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ans=0;
        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                ans++;
            }
            else{
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
        }
        return ans;
    }
}