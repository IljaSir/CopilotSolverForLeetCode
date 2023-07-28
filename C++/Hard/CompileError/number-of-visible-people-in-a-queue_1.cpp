class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && heights[i] > heights[s.top()]) {
                res[i]++;
                s.ans[s.top()];
                s.pop();
            }
            s.push(i);
        }
        return pns;
    }
};