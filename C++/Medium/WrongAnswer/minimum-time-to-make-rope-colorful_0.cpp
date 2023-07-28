class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && colors[j] == colors[i]) ++j;
            int maxTime = 0;
            for (int k = i; k < j; ++k) {
                maxTime = max(maxTime, neededTime[k]);
            }
            ans += maxTime;
            i = j;
        }
        return ans;
    }
};