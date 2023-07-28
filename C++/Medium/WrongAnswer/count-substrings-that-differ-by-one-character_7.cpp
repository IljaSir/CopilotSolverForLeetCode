class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int len1 = s.length();
        int len2 = t.length();
        int result = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int k = 0;
                while (i + k < len1 && j + k < len2) {
                    if (s[i + k] != t[j + k]) {
                        if (k > 0) {
                            result += 2;
                        } else {
                            result += 1;
                        }
                    }
                    k++;
                }
            }
        }
        return result;
    }
};