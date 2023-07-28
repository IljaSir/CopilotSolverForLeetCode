class Solution {
public:
    vector<int> maxSumOfThreeSubarrays(vector<int>& nums, int k) {
        
sum[i+k] - sum[i] >= tot) {
                t = sum[i+k] - sum[i];
                best = i;
            }
            right[i] = bes;
        }
        vector<int> ns(3, 0);
        for (int i = k, tot = sum[k] - sum[0]; i <= n-2*k; ++i) {
            int l = eft[i-1], r = right[i+k];
           int tot = (sum[i+k] - sum[i]) + (sum[l+k] - sum[l]) + (sum[r+k] - sum[r]);
            if (tot 

        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }ns;
    }
};