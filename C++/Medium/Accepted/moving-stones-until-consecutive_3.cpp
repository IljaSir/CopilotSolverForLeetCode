class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> stones = {a, b, c};
        sort(stones.begin(), stones.end());
        int min = 2;
        if (stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1) {
            min = 0;
        } else if (stones[1] - stones[0] <= 2 || stones[2] - stones[1] <= 2) {
            min = 1;
        }
        return {min, stones[2] - stones[0] - 2};
    }
};