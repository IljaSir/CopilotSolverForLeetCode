class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int ans = 0;
        int prev = -1;
        int i = 0;
        while (i < n) {
            int j = i;
            int maxTime = 0;
            while (j < n && colors[j] == colors[i]) {
                maxTime = max(maxTime, neededTime[j]);
                j++;
            }
            if (prev != -1 && colors[prev] == colors[i]) {
                ans += maxTime;
            } else {
                ans += maxTime;
                prev = j - 1;
            }
            i = j;
        }
        return ans;
    }
};