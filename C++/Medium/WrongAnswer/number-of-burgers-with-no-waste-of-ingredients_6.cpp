class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        if (tomatoSlices % 2 == 1) {
            return res;
        }
        int small = tomatoSlices / 2 - cheeseSlices;
        int jumbo = cheeseSlices - small;
        if (small >= 0 && jumbo >= 0) {
            res.push_back(jumbo);
            res.push_back(small);
        }
        return res;
    }
};