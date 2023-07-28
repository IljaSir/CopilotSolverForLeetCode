class Solution {
public:
    int numSub(string s) {
        
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '1') {
                cnt++;
                ans += cnt;
                ans %= 1000000007;
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
};