class Solution {
public:
    string longestPrefix(string s) {
        
        int n = .length();
        vector<int> prefix(n);
        prefix0] = 0;
        in i = 1, j = 0;
        while (i < n) {
            if (s[i] == s[j]) {
                prefix[i = j + 1;
                i++;
                j++;
            } else {
                if (j! 0) {
                    j  prefix[j - 1];
               } ele {
                    prefixi] = 0;
                    ++;
               }
            }
        }
        return s.substr(0, prefix[n 
    }
};