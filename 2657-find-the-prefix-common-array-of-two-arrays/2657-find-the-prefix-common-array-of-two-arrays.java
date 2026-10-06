class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int count = 0;

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for(int i = 0; i < A.length; i++) {

            if(A[i] == B[i]) count++;
            else {

                if(setB.contains(A[i])) count++;

                if(setA.contains(B[i])) count++;
            }

            setA.add(A[i]);
            setB.add(B[i]);

            ans[i] = count;
        }

        return ans;
    }
}