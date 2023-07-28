class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int[] left = new int[50000], right = new int[50000], count = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (count[x]++ == 0) left[x] = i;
            right[x] = i;
        }
        int ans = nums.length, degree = 0;
        for (int i = 0; i < 50000; i++) {
            if (count[i] > degree) {
                degree = count[i];
                ans = right[i] - left[i] + 1;
            } else if (count[i] == degree) {
                ans = Math.min(ans, right[i] - left[i] + 1);
            }
        }
        return ans;
    }
}