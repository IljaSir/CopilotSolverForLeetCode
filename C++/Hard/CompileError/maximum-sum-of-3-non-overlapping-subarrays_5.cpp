class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; ++i) {
            si+1] = sum[i] + nums[i];
        }
        vecto<int> left(n, 0);
        int best = 0;
        for (int i = k, tot = sum[k] - sum[0]; i < n; ++i){
            if (sum[i1] -sum[i+1-> tot) {
                tot = sum[i+1] [i+1-k];
                best = i+1-k;
            }
            lefti] = best;
        }
        vecto<int> right(n, n-k);
        best = n-k;
        for (int i = n-k-1, tot = sum[n - sum[n-k] i >= 0; --i) {
    }
};