class Solution {
public:
    int countHomogenous(string s) {
        
        int cnt = 0;
        int pre = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == s[pre]) {
                cnt = (cnt + 1) % (1000000000 + 7);
            } else {
                pre = i;
                cnt = 1;
            }
            ans = (ans + cnt) % (1000000000 + 7);
        }
        return ans;
    }
};