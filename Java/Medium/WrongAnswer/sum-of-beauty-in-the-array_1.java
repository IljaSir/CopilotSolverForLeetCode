class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
            max[nums.length - i - 1] = Math.max(max[nums.length - i], nums[nums.length - i - 1]);
        }
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > min[i - 1] && nums[i] < max[i + 1]) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}