class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ones;
        for (int i = 0; i < n; ++i) {
            if (nums[i]) {
                ones.push_back(i);
            }
        }
        int m = ones.size();
        int ans = INT_MAX;
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += ones[i];
        }
        ans = sum - ones[k / 2] * (k - k / 2);
        for (int i = k; i < m; ++i) {
            sum += ones[i] - ones[i - k];
            ans = min(ans, sum - ones[i - k / 2] * (k - k / 2));
        }
        return ans;
    }
};