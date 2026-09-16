class Solution {
    int[] t;
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];
//get your prefix sum array
        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
//sort them and store only unique prefix sum to avoid duplication in ranking
        TreeSet<Long> sortedSet = new TreeSet<>();
        for(long sum:prefixSum){
            sortedSet.add(sum);
            sortedSet.add(sum-upper);
            sortedSet.add(sum-lower);
        }
        Map<Long,Integer> map = new HashMap<>();
        int j=0;
//rank them accordingly for segment tree
        for(long sum:sortedSet){
            map.put(sum,j++);
        }
        int size = sortedSet.size();
        t = new int[size*4];
        int ans=0;
        for(Long sum:prefixSum){
// now again here from intuition , we are trying to find count of prefix(0->i) for each prefix(0->j) , and every prefix(0->i) will be between prefix(0->j)-lower , prefix(0->j)-upper
            int left = map.get(sum-upper);
            int right  = map.get(sum-lower);
            ans += query(0,0,size-1,left,right);
            update(map.get(sum),0,0,size-1);
        }
        return ans;
    }
// normal seg tree queries 
    public void update(int i , int v , int l , int r){
        if(l==r){
            t[v]++;
            return ;
        }
        int m = (l+r)/2;
        if(i<=m){
            update(i,v*2+1,l,m);
        }
        else{
            update(i,v*2+2,m+1,r);
        }
        t[v] = t[v*2+1]+t[v*2+2];
    }

    public int query(int v , int tl , int tr , int l , int r){
        if(l>r) return 0;
        if(tl==l && tr==r) return t[v];
        int tm = (tl+tr)/2;
        return query(v*2+1,tl,tm,l,Math.min(tm,r))+query(v*2+2,tm+1,tr,Math.max(tm+1,l),r);
    }
}