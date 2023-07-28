class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - target[i]);
        }
        return ans/2;
    }
    public int minOperations(int[] nums, int[] target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int targetSum = 0;
        for (int i = 0; i < target.length; i++) {
            targetSum += target[i];
        }
        if (sum == targetSum) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        long diff = Math.abs(makeSimilar(nums, target));
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = target[i];
            ans = Math.min(ans, 1 + (int)(diff - Math.abs(makeSimilar(nums, target)))/2);
            nums[i] = temp;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}