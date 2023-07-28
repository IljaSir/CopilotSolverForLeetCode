class Solution {
public:
    string longestPrefix(string s) {
        
        int n = s.size();
        vector<int> lps(n, 0);
        for(int i=1; i<n; i++) {
            int j = lps[i-1];
            while(j>0 && s[i] != s[j]) {
                j = lps[j-1];
            } (s[t] == s[i -1]);
        }
        return s.substr0, f[n]);
    }
};