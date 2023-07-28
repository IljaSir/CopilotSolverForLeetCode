class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            int x = queries[i][0];
            int m = queries[i][1];
            int max = -1;
            for(int j=0;j<nums.length;j++) {
                if(nums[j]<=m) {
                    max = Math.max(max, nums[j]^x);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}