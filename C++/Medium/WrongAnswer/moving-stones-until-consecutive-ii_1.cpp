class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        sort(stones.begin(), stones.end());
        int n = stones.size();
        int maxv = max(stones[n - 1] - stones[1] + 1 - n + 2, stones[n - 2] - stones[0] + 1 - n + 2);
        int minv = INT_MAX;
        int i = 0, j = 0;
        while (i < n) {
            while (j < n && stones[j] - stones[i] + 1 <= n) {
                j++;
            }
            int cnt = j - i;
            if (cnt == n - 1 && stones[j - 1] - stones[i] + 1 == n - 1) {
                minv = min(minv, 2);
            } else {
                minv = min(minv, n - cnt);
            }
            i++;
        }
        return {minv, maxv};
    }
};