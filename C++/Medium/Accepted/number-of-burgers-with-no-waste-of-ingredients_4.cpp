class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        int x = 0, y = 0;
        if (tomatoSlices % 2 == 0) {
            x = tomatoSlices / 2 - cheeseSlices;
            y = cheeseSlices - x;
            if (x >= 0 && y >= 0 && 4 * x + 2 * y == tomatoSlices)
                return {x, y};
        }
        return {};
    }
};