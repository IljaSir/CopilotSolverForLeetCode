class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> stones = {a, b, c};
        sort(stones.begin(), stones.end());
        if (stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1) {
            return {0, 0};
        }
        int minMove = 2;
        if (stones[1] - stones[0] <= 2 || stones[2] - stones[1] <= 2) {
            minMove = 1;
        }
        return {minMove, stones[2] - stones[0] - 2};
    }
};