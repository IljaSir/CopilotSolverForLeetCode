class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int count[3] = {0, 0, 0};
        for (int x : stones) {
            count[x % 3]++;
        }
        return count[0] % 2 == 0 ? (count[1] && count[2]) : !(count[1] && count[2]);
    }
};