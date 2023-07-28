class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        string ans = "";
        if (strs.size() == 0) return ans;
        if (strs.size() == 1) return strs[0];
        int minLen = strs[0].size();
        for (int i = 1; i < strs.size(); i++) {
            minLen = min(minLen, (int)strs[i].size());
        }
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.size(); j++) {
                if (strs[j][i] != strs[0][i]) {
                    return ans;
                }
            }
            ans += strs[0][i];
        }
        return ans;
    }
};