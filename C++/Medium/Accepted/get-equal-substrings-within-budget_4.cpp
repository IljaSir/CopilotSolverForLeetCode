class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int l = 0, r = 0;
        int n = s.length();
        int cost = 0;
        int ans = 0;
        while (r < n) {
            cost += abs(s[r] - t[r]);
            r++;
            while (cost > maxCost) {
                cost -= abs(s[l] - t[l]);
                l++;
            }
            ans = max(ans, r - l);
        }
        return ans;
    }
};