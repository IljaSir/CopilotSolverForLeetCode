class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        sort(stones.begin(), stones.end());
        int n = stones.size();
        int minMoves = INT_MAX;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && stones[j] - stones[i] < n) {
                j++;
            }
            if (j - i == n - 1 && stones[j - 1] - stones[i] == n - 2) {
                minMoves = min(minMoves, 2);
            } else {
                minMoves = min(minMoves, n - (j - i));
            }
        }
        return {minMoves, max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2)};
    }
};