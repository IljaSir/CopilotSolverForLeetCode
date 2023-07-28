class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end());
        int n = candidates.size();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = candidates[i];
            for (int j = i - 1; j >= 0; j--) {
                if ((tmp & candidates[j]) > 0) {
                    tmp &= candidates[j];
                    if (tmp == 1) {
                        break;
                    }
                }
            }
            res = max(res, tmp);
        }
        return res;
    }
};