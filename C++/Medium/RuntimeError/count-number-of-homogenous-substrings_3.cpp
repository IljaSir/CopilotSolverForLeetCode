class Solution {
public:
    int countHomogenous(string s) {
        
        int ans = 0;
        int n = s.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) j++;
            int len = j - i;
            ans = (ans + (len + 1) * len / 2) % 1000000007;
            i = j;
        }
        return ans;
    }
};