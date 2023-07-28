class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long ans = 0;
        long[] diff = new long[2000001];
        for (int i = 0; i < nums.length; i++) {
            diff[nums[i] + target[i]]++;
            diff[Math.abs(nums[i] - target[i]) + 1]--;
        }
        for (int i = 2; i < diff.length; i++) {
            diff[i] += diff[i - 2];
            ans = Math.max(ans, diff[i]);
        }
        return nums.length - ans;
    }
}