class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n < 2) return false;
        if (k == 0) {
            for (int i = 1; i < n; ++i) {
                if (nums[i] == 0 && nums[i-1] == 0) return true;
            }
            return false;
        }
        k = abs(k);
        vector<int> prefixSum(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = (prefixSum[i-1] + nums[i-1]) % k;
        }
        unordered_map<int, int> index;
        for (int i = 0; i <= n; ++i) {
            if (index.count(prefixSum[i]) == 0) {
                index[prefixSum[i]] = i;
            } else {
                if (i - index[prefixSum[i]] >= 2) return true;
            }
        }
        return false;
    }
};