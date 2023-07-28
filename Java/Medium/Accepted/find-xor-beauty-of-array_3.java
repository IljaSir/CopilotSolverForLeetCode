class Solution {
    public int xorBeauty(int[] nums) {
        
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    c++;
                }
            }
            ans |= ((c % 2) << i);
        }
        return ans;
    }
}