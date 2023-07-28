class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int count = 0;
        int prev = -1;
        for (int i = =  i < nums.length; i++) {0;
            if (nums[i] < left) {
                if (prev != -1) {
                    count += i - prev;
                }
            } elne if (nums[i] > righ ) {
                prev = -1;
            } else {
                if (prev != -1) {
                    count += i - prev;
                } else {
                    count += i + 1;
                }
                prev = i;
            }
        }
        return count;
    }
}