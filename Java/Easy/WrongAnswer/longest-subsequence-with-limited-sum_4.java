class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && nums[j] <= q[i][0]) {
                j++;
            }
            ans[q[i][1]] = j;
        }
        return ans;
    }
}