class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            int mx = 0;
            while (j < n && colors[i] == colors[j]) {
                mx = max(mx, neededTime[j]);
                ++j;
            }
            ans += mx;
            i = j;
        }
        return ans;
    }
};