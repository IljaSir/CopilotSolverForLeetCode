class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end());
        int n = candidates.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (ans >= candidates[i]) {
                continue;
            }
            int max = candidates[i];
            for (int j = i + 1; j < n; ++j) {
                if (max >= candidates[j]) {
                    continue;
                }
                int tmp = max & candidates[j];
                if (tmp > ans) {
                    ans = tmp;
                    max = tmp;
                }
            }
        }
        return ans;
    }
};