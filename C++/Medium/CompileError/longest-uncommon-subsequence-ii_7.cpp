class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        
        int n = strs.size();
        sort(strs.begin(), strs.end(), [](string a, string b) {
            return a.size() > b.size();
        });
        for (int i = 0; i < n; ++i) {
            bool isSub = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) return strs[i].size();
        }
        return -1;
    }
};