class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int n = s.size();
        int ans = 0;
        int cost = 0;
        int l = 0;
        for(int r = 0; r < n; r++) {
            cost += abs(s[r] - t[r]);
            while(cost > maxCost) {
                cost -= abs(s[l] - t[l]);
                l++;
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};