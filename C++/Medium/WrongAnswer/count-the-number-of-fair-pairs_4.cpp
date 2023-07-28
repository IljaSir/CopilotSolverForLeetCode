class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        vector<int> prefix(n+1, 0);
        for (int i = 0; i < n; i++)
            prefix[i+1] = prefix[i] + nums[i];
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = lower - prefix[i];
            int r = upper - prefix[i];
            int p = lower_bound(prefix.begin()+i+1, prefix.end(), l) - prefix.begin();
            int q = upper_bound(prefix.begin()+i+1, prefix.end(), r) - prefix.begin();
            ans += q - p;
        }
        return ans;
    }
};