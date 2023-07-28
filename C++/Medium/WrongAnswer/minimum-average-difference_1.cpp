class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int ans = 0;
        int min_diff = INT_MAX;
        for (int i = 0; i < n - 1; ++i) {
            int left = (prefix[i + 1] + i) / (i + 1);
            int right = (prefix[n] - prefix[i + 1]) / (n - i - 1);
            int diff = abs(left - right);
            if (diff < min_diff) {
                min_diff = diff;
                ans = i;
            }
        }
        return ans;
    }
};