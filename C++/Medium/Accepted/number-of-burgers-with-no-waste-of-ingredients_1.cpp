class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> res;
        int a = (tomatoSlices - 2 * cheeseSlices) / 2;
        int b = cheeseSlices - a;
        if (a >= 0 && b >= 0 && a * 4 + b * 2 == tomatoSlices) {
            res.push_back(a);
            res.push_back(b);
        }
        return res;
    }
};