class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        string res = "";
        int i = 0, j = 0;
        while (i < strs.size() && j < strs[i].size()) {
            char ch = strs[i][j];
            for (int k = i; k < strs.size(); k++) {
                if (j >= strs[k].size() || strs[k][j] != ch) {
                    return res;
                }
            }
            res += ch;
            j++;
        }
        return res;
    }
};