class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        int res = -1;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == n) res = max(res, (int)strs[i].length());
        }
        return res;
    }
};