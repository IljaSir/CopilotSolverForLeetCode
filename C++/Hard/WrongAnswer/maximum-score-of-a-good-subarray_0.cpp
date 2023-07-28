class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.top()] >= nums[i]) s.pop();
            if (!s.empty()) left[i] = s.top();
            s.push(i);
        }
        while (!s.empty()) s.pop();
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && nums[s.top()] >= nums[i]) s.pop();
            if (!s.empty()) right[i] = s.top();
            s.push(i);
        }
        int ans = nums[k];
        for (int i = k; i >= 0; --i) {
            ans = max(ans, nums[i] * (right[i] - left[i] - 1));
            if (nums[i] <= nums[k]) break;
        }
        for (int i = k; i < n; ++i) {
            ans = max(ans, nums[i] * (right[i] - left[i] - 1));
            if (nums[i] <= nums[k]) break;
        }
        return ans;
    }
};