class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ones;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                ones.push_back(i);
            }
        }
        int m = ones.size();
        vector<int> presum(m + 1, 0);
        for (int i = 1; i <= m; ++i) {
            presum[i] = presum[i - 1] + ones[i - 1];
        }
        int ans = INT_MAX;
        for (int i = 0; i <= m - k; ++i) {
            int j = i + k - 1;
            int mid = (i + j) / 2;
            int cur = presum[mid + 1] - presum[i] - (presum[j + 1] - presum[mid + 1]) + (mid - i + 1) * ones[mid] - (j - mid) * ones[mid];
            ans = min(ans, cur);
        }
        return ans;
    }
};