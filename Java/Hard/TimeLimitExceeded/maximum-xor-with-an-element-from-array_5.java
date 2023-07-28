class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            ans[i] = find(nums, queries[i][0], queries[i][1]);
        }
        return ans;
    }
    
    private int find(int[] nums, int x, int m) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m) {
                break;
            }
            ans = Math.max(ans, nums[i] ^ x);
        }
        return ans;
    }
}