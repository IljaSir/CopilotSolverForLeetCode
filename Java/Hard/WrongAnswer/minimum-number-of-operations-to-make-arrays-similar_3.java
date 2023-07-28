class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        int n = nums.length;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums[i] - target[i];
        }
        Arrays.sort(diff);
        long ans = 0;
        for (long d : diff) {
            if (d > 0) {
                ans += d;
            }
        }
        return ans;
    }
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long targetSum = 0;
        for (int i = 0; i < n; i++) {
            targetSum += target[i];
        }
        long diff = sum - targetSum;
        if (diff == 0) {
            return 0;
        }
        long ans = makeSimilar(nums, target);
        if (diff > 0) {
            ans = Math.min(ans, diff / 2);
        } else {
            ans = Math.min(ans, -diff / 2);
        }
        return (int) ans;
    }
}