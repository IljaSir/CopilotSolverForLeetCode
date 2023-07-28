class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.sort(nums);
        for (int i = 0; i < q; i++) {
            ans[i] = -1;
            int x = queries[i][0];
            int m = queries[i][1];
            if (m < nums[0]) {
                continue;
            }
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] > m) {
                    break;
                }
                max = Math.max(max, x ^ nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}