class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        int j = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && s[j] - s[i] <= k) {
                j++;
            }
            ans = max(ans, j - i);
        }
        return ans;
    }
};