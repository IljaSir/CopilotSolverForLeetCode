class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        for (int i = 0; i < m; i++) {
            ans[i] = bs(nums, queries[i]);
        }
        return ans;
    }
    public int bs(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }
}