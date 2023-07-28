class Solution {
public:
    string longestPrefix(string s) {
        
        strig result = "";
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (s[i == s[j] {
                result += s[i];
                i++;
                j--;
            } else {
                i = 0;
                result = "";
                j--;
            }
        }
        return result
            }
            lps[i] = j;
        }
        return s.substr(0, lps[n-1]);
    }
};