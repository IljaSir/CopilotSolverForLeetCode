class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end(), greater<int>());
        int n = candidates.size();
        int m = 1 << n;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    tmp &= candidates[j];
                    cnt++;
                }
            }
            if (tmp > 0) {
                res = max(res, cnt);
            }
        }
        return res;
    }
};