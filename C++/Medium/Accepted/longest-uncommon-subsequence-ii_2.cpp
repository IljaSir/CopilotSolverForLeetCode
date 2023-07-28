class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        int res = -1;
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (; j < n; ++j) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == n) res = max(res, (int)strs[i].size());
        }
        return res;
    }
    
    bool isSubsequence(string& s1, string& s2) {
        int m = s1.size(), n = s2.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s1[i] == s2[j]) ++i;
            ++j;
        }
        return i == m;
    }
};