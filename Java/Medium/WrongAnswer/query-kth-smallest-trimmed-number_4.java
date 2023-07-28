class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = kthSmallest(nums, queries[i][0], queries[i][1]);
        }
        return ans;
    }
    
    public int kthSmallest(String[] nums, int k, int trim) {
        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = Integer.parseInt(nums[i].substring(0, nums[i].length() - trim + 1));
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}