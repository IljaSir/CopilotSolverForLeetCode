class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == n) {
                ans = max(ans, (int)strs[i].size());
            }
        }
        return ans;
    }
    
    bool isSubsequence(string& s, string& t) {
        int n = s.size();
        int m = t.size();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s[i] == t[j]) j++;
        }
        return j == m;
    }
};