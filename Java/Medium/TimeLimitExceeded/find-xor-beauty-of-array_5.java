class Solution {
    public int xorBeauty(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int j = 0; j < n; j++) {
                int b = nums[j];
                for (int k = 0; k < n; k++) {
                    int c = nums[k];
                    ans ^= ((a | b) & c);
                }
            }
        }
        return ans;
    }
}