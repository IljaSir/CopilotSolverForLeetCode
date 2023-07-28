class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        int jumbo = 0;
        int small = 0;
        if(tomatoSlices < cheeseSlices) return res;
        if(tomatoSlices % 2 != 0) return res;
        if(tomatoSlices == 0 && cheeseSlices == 0) {
            res.push_back(0);
            res.push_back(0);
            return res;
        }
        if(tomatoSlices == 0 && cheeseSlices != 0) return res;
        if(tomatoSlices != 0 && cheeseSlices == 0) return res;
        if(tomatoSlices % 2 == 0) {
            jumbo = tomatoSlices / 2 - cheeseSlices;
            small = cheeseSlices - jumbo;
            if(jumbo < 0 || small < 0) return res;
            res.push_back(jumbo);
            res.push_back(small);
            return res;
        }
        return res;
    }
};