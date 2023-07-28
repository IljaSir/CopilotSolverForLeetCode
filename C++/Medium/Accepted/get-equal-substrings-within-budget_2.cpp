class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int l = 0;
        int r = 0;
        int cost = 0;
        int res = 0;
        while (r < s.size()) {
            cost += abs(s[r] - t[r]);
            r++;
            while (cost > maxCost) {
                cost -= abs(s[l] - t[l]);
                l++;
            }
            res = max(res, r - l);
        }
        return res;
    }
};