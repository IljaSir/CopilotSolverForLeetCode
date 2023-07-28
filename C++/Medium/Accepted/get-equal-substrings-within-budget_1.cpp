class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int l = 0, r = 0, cost = 0, ans = 0;
        while (r < s.size()) {
            cost += abs(s[r] - t[r]);
            while (cost > maxCost) {
                cost -= abs(s[l] - t[l]);
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};