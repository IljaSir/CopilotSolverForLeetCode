class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        
        int n = stones.size();
        if (n == 1) {
            return stones[0];
        }
        sort(stones.begin(), stones.end());
        while (stones[n - 2] != 0) {
            stones[n - 1] -= stones[n - 2];
            stones[n - 2] = 0;
            sort(stones.begin(), stones.end());
        }
        return stones[n - 1];
    }
};