class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int n = s.size();
        vector<int> sub(n, 0);
        for (int i = 0; i < n; i++) {
            sub[i] = abs(s[i] - t[i]);
        }
        int sum = 0;
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            sum += sub[r];
            while (sum > maxCost) {
                sum -= sub[l];
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};