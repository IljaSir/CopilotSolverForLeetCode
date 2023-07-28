class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        
        int n = s.size();
        vector<int> diff(n);
        for (int i = 0; i < n; ++i) {
            diff[i] = abs(s[i] - t[i]);
        }
        int ans = 0;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            sum += diff[r];
            while (sum > maxCost) {
                sum -= diff[l];
                ++l;
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};