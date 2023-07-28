class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int odd = 0, even = 0;
        for (int i : stones) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return odd % 2 == 0 || even % 2 == 0;
    }
};