class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        string result;
        if (strs.size() == 0) return result;
        if (strs.size() == 1) return strs[0];
        int minLen = INT_MAX;
        for (auto s : strs) {
            minLen = min(minLen, (int)s.size());
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0][i];
            for (int j = 1; j < strs.size(); j++) {
                if (strs[j][i] != c) {
                    return result;
                }
            }
            result.push_back(c);
        }
        return result;
    }
};