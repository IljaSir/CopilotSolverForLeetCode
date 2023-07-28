class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && heights[s.top()] <= heights[i]) {
                res[s.top()]++;
                s.pop();
            }
            if (!s.empty()) res[s.top()]++;
            s.push(i);
        }
        return res;
    }
};