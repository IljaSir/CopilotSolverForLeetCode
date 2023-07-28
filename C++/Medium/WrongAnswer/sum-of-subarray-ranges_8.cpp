class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        long long res = 0, n = nums.size();
        vector<long long> left(n, 0), right(n, 0);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.top()] > nums[i]) s.pop();
            left[i] = s.empty() ? i + 1 : i - s.top();
            s.push(i);
        }
        while (!s.empty()) s.pop();
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && nums[s.top()] >= nums[i]) s.pop();
            right[i] = s.empty() ? n - i : s.top() - i;
            s.push(i);
        }
        for (int i = 0; i < n; ++i) {
            res += nums[i] * left[i] * right[i];
        }
        return res;
    }
};