class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                cur &= nums[j];
                if (cur == 0) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}
    }
}