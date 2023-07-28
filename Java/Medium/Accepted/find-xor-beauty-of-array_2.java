class Solution {
    public int xorBeauty(int[] nums) {
        
        int n = nums.length;
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] % 2 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}