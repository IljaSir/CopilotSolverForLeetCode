class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int i = 0, res = 0;
        for (int j = 0; j < n; ++j) {
            if (count[nums[j]] == 0) {
                --k;
            }
            ++count[nums[j]];
            while (k < 0) {
                --count[nums[i]];
                if (count[nums[i]] == 0) {
                    ++k;
                }
                ++i;
            }
            res += j - i + 1;
        }
        return res;
    }
}