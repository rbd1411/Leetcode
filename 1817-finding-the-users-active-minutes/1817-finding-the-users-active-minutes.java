class Pair {
    private List<Integer> list;
    private int numberOfMins;
    
    public Pair(List<Integer> list, int numberOfMins) {
        this.list = list;
        this.numberOfMins = numberOfMins;
    }

    public List<Integer> getList() {
        return this.list;
    }

    public void setList() {
        this.list = list;
    }

    public int getN() {
        return this.numberOfMins;
    }

    public void setN(int numberOfMins) {
        this.numberOfMins = numberOfMins;
    }

}

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] oneBasedIndexResult = new int[k];
        HashMap<Integer, Pair> hash = new HashMap<>();
        for(int[] pair : logs) {
            int userId = pair[0];
            int minAction = pair[1];

            if(!hash.containsKey(userId)) {
                List<Integer> intializedList = new ArrayList<>();
                intializedList.add(minAction);
                hash.put(userId, new Pair(intializedList, -1));
            } else {
                hash.get(userId).getList().add(minAction);  
            }
        }

        for(Map.Entry<Integer, Pair> map : hash.entrySet()) {
            List<Integer> lis = map.getValue().getList();
            HashSet<Integer> dupsRemoved = helperMethod_dupsRemove(lis); 

            int tempAns = dupsRemoved.size();
            
               oneBasedIndexResult[tempAns - 1]++;
            
        }

        return oneBasedIndexResult;
    }

    public HashSet<Integer> helperMethod_dupsRemove(List<Integer> inputList) {
        return new HashSet<Integer>(inputList);
    }
}