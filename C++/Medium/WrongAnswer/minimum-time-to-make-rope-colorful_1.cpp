class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int i = 0;
        int ans = 0;
        while (i < n) {
            int j = i;
            int maxTime = 0;
            while (j < n && colors[j] == colors[i]) {
                maxTime = max(maxTime, neededTime[j]);
                j++;
            }
            ans += maxTime;
            i = j;
        }
        return ans;
    }
};