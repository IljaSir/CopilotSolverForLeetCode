class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                if (set.contains(nums[j] ^ 32)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}