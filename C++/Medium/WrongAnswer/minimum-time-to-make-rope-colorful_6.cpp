class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int res = 0;
        int cur = 0;
        char c = colors[0];
        for (int i = 0; i < n; ++i) {
            if (colors[i] != c) {
                res += max(cur, neededTime[i]);
                cur = 0;
                c = colors[i];
            } else {
                cur += neededTime[i];
            }
        }
        return res + cur;
    }
};