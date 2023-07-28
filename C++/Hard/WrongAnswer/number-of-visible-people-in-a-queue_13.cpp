class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> ans(n, 0);
        stack<int> stk;
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.empty() && heights[i] > heights[stk.top()]) {
                ans[i]++;
                ans[stk.top()]++;
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }
};