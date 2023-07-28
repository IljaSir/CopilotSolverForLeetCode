class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        int jumbo = 0;
        int small = 0;
        if (tomatoSlices % 2 == 0) {
            jumbo = tomatoSlices / 2 - cheeseSlices;
            small = cheeseSlices - jumbo;
        }
        if (jumbo < 0 || small < 0) {
            return {};
        }
        return {jumbo, small};
    }
};