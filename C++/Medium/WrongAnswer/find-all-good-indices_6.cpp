class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        
        vector<int> ans;
        int n = nums.size();
        vector<int> pre(n, 0);
        vector<int> suf(n, 0);
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = max(pre[i - 1], nums[i]);
        }
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = min(suf[i + 1], nums[i]);
        }
        for (int i = k; i < n - k; i++) {
            if (pre[i - 1] <= nums[i] && suf[i + 1] >= nums[i]) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};