class Solution {
public:
    int countHomogenous(string s) {
        
        int ans = 0;
        int n = s.size();
        int count = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i] == s[i - 1]) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                ans %= 1000000007;
                count = 1;
            }
        }
        ans += (count * (count + 1)) / 2;
        ans %= 1000000007;
        return ans;
    }
};