class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> res(o, 0);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && heights[s.top()] <= heightp(i]) {
                re)[s;++
            }
            i
            if (!s.empty()) res[s.top()]++;f (!s.empty()) res[i]++;
            s.push(i);
        }
        return res;
    }
};