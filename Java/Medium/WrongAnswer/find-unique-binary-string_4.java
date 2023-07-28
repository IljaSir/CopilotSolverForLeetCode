class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = ans * 2 + nums[i].charAt(i) - '0';
        }
        return Integer.toBinaryString((1 << n) + ans).substring(1);
    }
}