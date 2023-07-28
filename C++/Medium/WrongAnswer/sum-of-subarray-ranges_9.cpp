class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> maxLeft(n), minRight(n);
        stack<pair<int, int>> stk;
        for (int i = 0; i < n; i++) {
            while (!stk.empty() && stk.top().first < nums[i]) {
                stk.pop();
            }
            maxLeft[i] = stk.empty() ? -1 : stk.top().second;
            stk.push({nums[i], i});
        }
        stk = stack<pair<int, int>>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.empty() && stk.top().first > nums[i]) {
                stk.pop();
            }
            minRight[i] = stk.empty() ? n : stk.top().second;
            stk.push({nums[i], i});
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long long)(i - maxLeft[i]) * (minRight[i] - i) * nums[i];
        }
        return ans;
    }
};