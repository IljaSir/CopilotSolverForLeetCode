class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) sums[i] = sums[i - 1] + nums[i];
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (sums[mid] - sums[i] >= sums[i]) r = mid;
                else l = mid + 1;
            }
            if (sums[l] - sums[i] < sums[i]) continue;
            int ll = l, rr = n - 1;
            while (ll < rr) {
                int mid = ll + (rr - ll + 1) / 2;
                if (sums[mid] - sums[i] > sums[n - 1] - sums[mid]) rr = mid - 1;
                else ll = mid;
            }
            ans = (ans + ll - l + 1) % mod;
        }
        return ans;
    }
}