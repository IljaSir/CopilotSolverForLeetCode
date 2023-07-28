class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        
        sort(candidates.begin(), candidates.end(), greater<int>());
        int n = candidates.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int mask = 1 << 30;
            int j = i;
            int cur = 0;
            while (j < n && mask > 0) {
                if (candidates[j] & mask) {
                    cur += mask;
                    mask >>= 1;
                } else {
                    j++;
                }
            }
            ans = max(ans, __builtin_popcount(cur));
        }
        return ans;
    }
};