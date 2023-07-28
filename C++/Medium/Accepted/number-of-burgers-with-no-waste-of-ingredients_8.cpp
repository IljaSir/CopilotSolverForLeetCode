class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        if (tomatoSlices % 2 || tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices) {
            return res;
        }
        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;
        res.push_back(jumbo);
        res.push_back(small);
        return res;
    }
};