class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // Use bruteforce approach since constraints are very small
        
        // Create two boolean arrays of length 101
        boolean[] array1 = new boolean[101];
        boolean[] array2 = new boolean[101];

        // For each number in the nums1 array, set the item with the index of that number to true in array1
        for (int num : nums1) {
            array1[num] = true;
        }

        // Likewise, do the same for array2
        for (int num : nums2) {
            array2[num] = true;
        }

        // These will count the number of common integers between the two arrays
        int answer1 = 0;
        int answer2 = 0;

        for (int num : nums1) {
            if (array2[num]) {
                answer1++;
            }
        }

        for (int num : nums2) {
            if (array1[num]) {
                answer2++;
            }
        }

        // Store and return result as an array

        int[] result = {answer1, answer2};

        return result;
    }
}