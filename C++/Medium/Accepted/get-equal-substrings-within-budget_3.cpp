class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int n = s.length();
        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;
        while (r < n) {
            sum += abs(s[r] - t[r]);
            while (sum > maxCost) {
                sum -= abs(s[l] - t[l]);
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};