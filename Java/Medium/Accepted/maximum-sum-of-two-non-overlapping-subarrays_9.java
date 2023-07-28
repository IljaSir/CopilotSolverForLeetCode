class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int[] sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i + firstLen <= nums.length; i++) {
            int first = sum[i+firstLen] - sum[i];
            for (int j = 0; j + secondLen <= nums.length; j++) {
                if (i >= j + secondLen || j >= i + firstLen) {
                    int second = sum[j+secondLen] - sum[j];
                    ans = Math.max(ans, first + second);
                }
            }
        }
        return ans;
    }
}