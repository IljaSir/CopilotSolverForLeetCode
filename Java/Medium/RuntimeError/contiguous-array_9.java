class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        int[] count = new int[n+1];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (sum == 0) {
                max = i + 1;
            } else {
                if (count[sum + n] == 0) {
                    count[sum + n] = i + 1;
                } else {
                    max = Math.max(max, i + 1 - count[sum + n]);
                }
            }
        }
        return max;
    }
}