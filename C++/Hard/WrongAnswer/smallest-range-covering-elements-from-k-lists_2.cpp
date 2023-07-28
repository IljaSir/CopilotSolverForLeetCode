class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int k = nums.size();
        vector<int> cur(k, 0);
        int left = INT_MAX, right = INT_MIN;
        for (int i = 0; i < k; i++) {
            left = min(left, nums[i][0]);
            right = max(right, nums[i][0]);
        }
        vector<int> ans = {left, right};
        while (true) {
            int idx = -1, mn = INT_MAX;
            for (int i = 0; i < k; i++) {
                if (cur[i] + 1 < nums[i].size() && mn > nums[i][cur[i] + 1]) {
                    idx = i;
                    mn = nums[i][cur[i] + 1];
                }
            }
            if (idx == -1) {
                break;
            }
            cur[idx]++;
            left = INT_MAX;
            for (int i = 0; i < k; i++) {
                left = min(left, nums[i][cur[i]]);
            }
            if (right - left < ans[1] - ans[0]) {
                ans = {left, right};
            }
            right = max(right, mn);
        }
        return ans;
    }
};