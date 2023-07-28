class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n-k+1, 0);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (i >= k) sum -= nums[i-k];
            if (i >= k-1) sums[i-k+1] = sum;
        }
        vector<int> left(n-k+1, 0);
        int best = 0;
        for (int i = 0; i < sums.size(); ++i) {
            if (sums[i] > sums[best]) best = i;
            left[i] = best;
        }
        vector<int> right(n-k+1, n-k);
        best = n-k;
        for (int i = n-k; i >= 0; --i) {
            if (sums[i] >= sums[best]) best = i;
            right[i] = best;
        }
        vector<int> ans(3, -1);
        for (int j = k; j <= n-2*k; ++j) {
            int i = left[j-k], l = right[j+k];
            if (ans[0] == -1 || sums[i]+sums[j]+sums[l] > sums[ans[0]]+sums[ans[1]]+sums[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = l;
            }
        }
        return ans;
    }
};