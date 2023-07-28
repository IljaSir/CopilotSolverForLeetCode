class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        int n = strs.size();
        if (n == 0) return "";
        if (n == 1) return strs[0];
        string prefix = strs[0];
        for (int i = 1; i < n; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix[j] != strs[i][j]) break;
            }
            prefix = prefix.substr(0, j);
        }
        return prefix;
    }
};