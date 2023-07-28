class Solution {
public:
    int countHomogenous(string s) {
        
        int ans = 0;
        int cnt = 1;
        for (int i = 1; i < s.size(); i++) {
            if (s[i] == s[i-1]) {
                cnt++;
            } else {
                ans += ((cnt+1) * cnt) / 2;
                cnt = 1;
            }
            ans %= 1000000007;
        }
        ans += ((cnt+1) * cnt) / 2;
        ans %= 1000000007;
        return ans;
    }
};