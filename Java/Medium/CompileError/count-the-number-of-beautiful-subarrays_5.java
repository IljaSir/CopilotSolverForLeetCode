class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        return atMost(nums, 1) - atMost(nums, 0);
    }
    private long atMost(int[] nums, int k) {
        long res = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            k -= nums[j] % 2;
            while (k < 0) {
                k += nums[i++] % 2;
            }
            res += j - i + 1;
        }
        return res;
    }
}
    }
}