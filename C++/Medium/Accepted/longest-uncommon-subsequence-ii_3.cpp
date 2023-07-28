class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int j = 0;
            for (; j < n; ++j) {
                if (i == j) continue;
                if (isSub(strs[i], strs[j])) break;
            }
            if (j == n) ans = max(ans, (int)strs[i].size());
        }
        return ans;
    }
    bool isSub(string& a, string& b) {
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a[i] == b[j]) ++i;
            ++j;
        }
        return i == a.size();
    }
};