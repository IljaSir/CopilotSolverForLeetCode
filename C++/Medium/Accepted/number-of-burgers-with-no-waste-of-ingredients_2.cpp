class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        if (tomatoSlices % 2 == 1) return res;
        int x = tomatoSlices / 2 - cheeseSlices;
        int y = cheeseSlices - x;
        if (x >= 0 && y >= 0 && x + y == cheeseSlices && 4 * x + 2 * y == tomatoSlices) {
            res.push_back(x);
            res.push_back(y);
        }
        return res;
    }
};