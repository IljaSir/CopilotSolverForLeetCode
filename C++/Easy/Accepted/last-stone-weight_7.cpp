class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        
        sort(stones.begin(), stones.end());
        while (stones.size() > 1) {
            int last = stones.size() - 1;
            int secondLast = stones.size() - 2;
            if (stones[last] == stones[secondLast]) {
                stones.erase(stones.begin() + last);
                stones.erase(stones.begin() + secondLast);
            } else {
                stones[secondLast] = stones[last] - stones[secondLast];
                stones.erase(stones.begin() + last);
                sort(stones.begin(), stones.end());
            }
        }
        return stones.size() == 0 ? 0 : stones[0];
    }
};