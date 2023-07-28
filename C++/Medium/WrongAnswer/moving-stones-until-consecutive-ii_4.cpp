class Solution {
public:
    vector<int> numMovesStonesII(vector<int>& stones) {
        
        int n = stones.size();
        sort(stones.begin(), stones.end());
        int minMoves = n;
        int maxMoves = stones[n-1] - stones[0] + 1 - n;
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && stones[j] - stones[i] < n) {
                j++;
            }
            int cost = n - (j - i);
            if (j - i == n - 1 && stones[j-1] - stones[i] + 1 == n - 1) {
                cost = 2;
            }
            minMoves = min(minMoves, cost);
            i++;
        }
        return {minMoves, maxMoves};
    }
};