class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        
        while (stones.size() > 1) {
            int max1 = 0, max2 = 0;
            int index1 = 0, index2 = 0;
            for (int i = 0; i < stones.size(); i++) {
                if (stones[i] > max1) {
                    max2 = max1;
                    index2 = index1;
                    max1 = stones[i];
                    index1 = i;
                } else if (stones[i] > max2) {
                    max2 = stones[i];
                    index2 = i;
                }
            }
            if (max1 == max2) {
                stones.erase(stones.begin() + index1);
                stones.erase(stones.begin() + index2 - 1);
            } else {
                stones[index1] = max1 - max2;
                stones.erase(stones.begin() + index2);
            }
        }
        if (stones.size() == 0) return 0;
        return stones[0];
    }
};