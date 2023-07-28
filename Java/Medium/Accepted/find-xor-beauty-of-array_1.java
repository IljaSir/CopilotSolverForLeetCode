class Solution {
    public int xorBeauty(int[] nums) {
        
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    cnt++;
                }
            }
            ans |= ((cnt % 2) << i);
        }
        return ans;
    }
}