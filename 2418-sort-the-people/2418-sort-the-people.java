class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        qs(names,heights,0,heights.length-1);
        return names;

    }
    public void qs(String[] names,int heights[],int low,int high){
        if(low>=high) return;
        int start=low;
        int end=high;
        int mid=start+(end-start)/2;
        int pivot=heights[mid];
        while(start<=end){
            while(heights[start]>pivot){
                start++;
            }
            while(heights[end]<pivot){
                end--;
            }
            if(start<=end){
                int temp=heights[start];
                heights[start]=heights[end];
                heights[end]=temp;
                String s=names[start];
                names[start]=names[end];
                names[end]=s;
                start++;
                end--;
            }
        }
        qs(names,heights,low,end);
        qs(names,heights,start,high);
    }
}