class Solution {
public:
    int countHomogenous(string s) {
        
        int n = s.length();
        int res = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) {
                count++;
            } else {
                res += (count * (count + 1)) / 2;
                res %= 1000000007;
                count = 1;
            }
        }
        res += (count * (count + 1)) / 2;
        res %= 1000000007;
        return res;
    }
};