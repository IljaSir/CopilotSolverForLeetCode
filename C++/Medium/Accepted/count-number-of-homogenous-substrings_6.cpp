class Solution {
public:
    int countHomogenous(string s) {
        
        int n = s.size();
        int i = 0, j = 0;
        long long res = 0;
        while (j < n) {
            while (j < n && s[i] == s[j]) {
                j++;
            }
            long long len = j - i;
            res = (res + (len * (len + 1) / 2)) % 1000000007;
            i = j;
        }
        return res;
    }
};