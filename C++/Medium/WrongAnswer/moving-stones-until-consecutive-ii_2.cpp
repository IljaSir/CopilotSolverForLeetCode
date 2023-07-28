class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        int n = stones.size();
        sort(stones.begin(), stones.end());
        int minMoves = INT_MAX;
        int maxMoves = stones[n - 1] - stones[0] - n + 1;
        int left = 0, right = 0;
        while (right < n) {
            while (right < n && stones[right] - stones[left] + 1 <= n) {
                ++right;
            }
            int cost = n - (right - left);
            if (right - left == n - 1 && stones[right - 1] - stones[left] + 1 == n - 1) {
                cost = 2;
            }
            minMoves = min(minMoves, cost);
            ++left;
        }
        return {minMoves, maxMoves};
    }
};