class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> stones = {a, b, c};
        sort(stones.begin(), stones.end());
        int min = 0;
        int max = stones[2] - stones[0] - 2;
        if(stones[1] - stones[0] > 1 && stones[2] - stones[1] > 1){
            min = 2;
        } else if(stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1){
            min = 0;
        } else {
            min = 1;
        }
        return {min, max};
    }
};