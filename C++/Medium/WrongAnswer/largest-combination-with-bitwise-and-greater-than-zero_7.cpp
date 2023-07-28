class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end());
        int n = candidates.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j + 1 < n && candidates[j + 1] == candidates[i]) {
                ++j;
            }
            if (candidates[i] == 1) {
                res = max(res, j - i + 1);
            } else {
                int k = 30;
                while (k >= 0 && (candidates[i] & (1 << k)) == 0) {
                    --k;
                }
                int mask = (1 << (k + 1)) - 1;
                int x = candidates[i] & mask;
                int y = (1 << (k + 1)) - 1 - x;
                int cnt = 0;
                int p = n - 1;
                while (p >= 0 && cnt < y) {
                    if (candidates[p] & (1 << k)) {
                        ++cnt;
                    }
                    --p;
                }
                if (cnt == y) {
                    res = max(res, j - i + 1 + n - 1 - p);
                }
            }
            i = j;
        }
        return res;
    }
};