class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int N = strs.size();
        vector<int> parent(N, -1);
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    unionSet(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (parent[i] < 0) {
                ++count;
            }
        }
        return count;
    }
};