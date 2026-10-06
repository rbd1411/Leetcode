class Solution {
    public int countPoints(String rings) {
        HashMap<Character,Set<Character>> hm=new HashMap<>();
        for(int i=0;i<rings.length()-1;i+=2){
            hm.putIfAbsent(rings.charAt(i+1),new HashSet<Character>());
            hm.get(rings.charAt(i+1)).add(rings.charAt(i));
        }
        int cnt=0;
        for(Character chr:hm.keySet()){
            if(hm.get(chr).size()==3) cnt+=1;
        }
        return cnt;
    }
}