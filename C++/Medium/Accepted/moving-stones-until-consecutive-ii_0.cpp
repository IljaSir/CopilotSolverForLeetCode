class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        sort(stones.begin(), stones.end());
        int n = stones.size();
        int maxMove = max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2);
        int minMove = maxMove;
        int i = 0, j = 0;
        while (j < n) {
            while (stones[j] - stones[i] >= n) {
                i++;
            }
            int cnt = j - i + 1;
            if (cnt == n - 1 && stones[j] - stones[i] == n - 2) {
                minMove = min(minMove, 2);
            } else {
                minMove = min(minMove, n - cnt);
            }
            j++;
        }
        return {minMove, maxMove};
    }
};