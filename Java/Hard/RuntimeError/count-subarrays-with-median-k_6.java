class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num < k ? -1 : 1;
            res += count[sum];
            count[sum]++;
        }
        return res;
    }
}