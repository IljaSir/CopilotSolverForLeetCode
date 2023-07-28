class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            while (!s.empty() && nums[s.top()] >= nums[i]) s.pop();
            if (!s.empty()) left[i] = s.top();
            s.push(i);
        }
        while (!s.empty()) s.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && nums[s.top()] >= nums[i]) s.pop();
            if (!s.empty()) right[i] = s.top();
            s.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] < k && k < right[i])
                res = max(res, nums[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
};