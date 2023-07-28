class Solution {
    public int countMaxOrSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    curr |= nums[j];
                }
            }
            if (curr > max) {
                max = curr;
                res = 1;
            } else if (curr == max) {
                res++;
            }
        }
        return res;
    }
}