class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int ans = 0, last = 0;
        for (int i = 1; i < n; ++i) {
            if (colors[i] == colors[i - 1]) {
                last = max(last, neededTime[i]);
            } else {
                ans += last + neededTime[i - 1];
                last = 0;
            }
        }
        return ans + last + neededTime.back();
    }
};