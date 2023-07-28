class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end());
        int n = candidates.size();
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            if (candidates[i] == candidates[i - 1]) {
                continue;
            }
            int temp = 0;
            for (int j = i; j < n; j++) {
                if ((temp & candidates[j]) > 0) {
                    continue;
                }
                temp |= candidates[j];
                res = max(res, temp);
            }
        }
        return res;
    }
};