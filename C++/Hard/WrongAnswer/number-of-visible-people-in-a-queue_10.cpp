class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> ans(n, 0);
        stack<int> s;
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && heights[s.top()] < heights[i]) {
                ++ans[i];
                ++ans[s.top()];
                s.pop();
            }
            s.push(i);
        }
        return ans;
    }
};