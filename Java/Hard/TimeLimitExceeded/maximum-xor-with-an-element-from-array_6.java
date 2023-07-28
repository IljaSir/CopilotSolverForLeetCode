class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int x = q[0];
            int m = q[1];
            ans[i] = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > m) break;
                ans[i] = Math.max(ans[i], x ^ nums[j]);
            }
        }
        return ans;
    }
}