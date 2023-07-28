class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;
        if (jumbo >= 0 && small >= 0 && 4 * jumbo + 2 * small == tomatoSlices) {
            res.push_back(jumbo);
            res.push_back(small);
        }
        return res;
    }
};