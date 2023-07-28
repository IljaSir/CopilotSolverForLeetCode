class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k) >= 0) ans++;
        }
        return ans;
    }
}