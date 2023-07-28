class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        int n = stones.size();
        if (n <= 2) return {0, 0};
        sort(stones.begin(), stones.end());
        int min_moves = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int j = upper_bound(stones.begin(), stones.end(), stones[i] + n - 1) - stones.begin();
            int moves = n - (j - i);
            if (j < n && stones[j] == stones[i] + n - 1) --moves;
            if (i == 0) moves = min(moves, 2 - (stones[1] - stones[0] - 1));
            if (j == n) moves = min(moves, 2 - (stones[n - 1] - stones[n - 2] - 1));
            min_moves = min(min_moves, moves);
        }
        return {min_moves, max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2)};
    }
};