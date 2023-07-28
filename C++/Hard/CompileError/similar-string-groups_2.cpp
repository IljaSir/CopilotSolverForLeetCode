class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        vector<int> p(n);
        for (int i = 0; i < n; ++i) p[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (p[i] == p[j] && isSimilar(strs[i], strs[j])) {
                    p[j] = p[i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (p[i] == i) ++ans;
        }
        return ans;
    }
};