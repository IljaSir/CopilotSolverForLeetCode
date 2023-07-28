class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}