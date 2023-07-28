class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end(), greater<int>());
        int n = candidates.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int num = candidates[i];
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int num2 = candidates[j];
                if ((num & num2) > 0) {
                    res = max(res, __builtin_popcount(num & num2));
                }
            }
        }
        return res;
    }
};