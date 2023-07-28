class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && heights[i] > heights[s.top()]) {
                res[i]++;
                s.pop();
            }
            if (!s.empty()) res[i]++;
            s.push(i);
        }
        return res;
    }
};