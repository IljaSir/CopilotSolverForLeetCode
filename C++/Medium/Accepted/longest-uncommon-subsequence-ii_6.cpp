class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int maxLen = -1;
        for (int i = 0; i < strs.size(); i++) {
            bool isSub = false;
            for (int j = 0; j < strs.size(); j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                maxLen = max(maxLen, (int)strs[i].length());
            }
        }
        return maxLen;
    }
    
    bool isSubsequence(string s, string t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
};