class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.top()] >= nums[i]) {
                right[s.top()] = i;
                s.pop();
            }
            if (!s.empty()) left[i] = s.top();
            s.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] == -1 && right[i] == n) {
                ans += nums[i];
            }
        }
        return ans;
    }
};