class Solution {
    public int xorBeauty(int[] nums) {
        
        int ans = 0;
        int n = nums.length;
        int[] count = new int[32];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    count[j] += 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int beauty = 0;
            for (int j = 0; j < 32; j++) {
                if ((num & (1 << j)) != 0) {
                    beauty += (1 << j) * (n - count[j]);
                } else {
                    beauty += (1 << j) * count[j];
                }
            }
            ans ^= beauty;
        }
        return ans;
    }
}