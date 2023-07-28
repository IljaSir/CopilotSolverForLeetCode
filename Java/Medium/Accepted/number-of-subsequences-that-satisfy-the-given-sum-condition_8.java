class Solution {
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mod = (int)1e9 + 7;
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = power[i - 1] * 2 % mod;
        }
        int count = 0;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + power[right - left]) % mod;
                left++;
            }
        }
        return count;
    }
}