class Solution {
    public boolean xorGame(int[] nums) {
        
        if (nums.length % 2 == 0) return true;
        int res = 0;
        for (int n: nums) res ^= n;
        return res == 0;
    }
}