class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }

        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            int last = map.get(s.charAt(i));
            end = Math.max(end,last);

            if(end==i)
            {
                end = 0;
                result.add(i-start+1);
                start = i+1;
            }
        }

        return result;
    }
}