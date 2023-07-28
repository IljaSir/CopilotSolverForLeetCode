class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        if(tomatoSlices % 2) return {};
        if(tomatoSlices < 2 * cheeseSlices) return {};
        if(tomatoSlices > 4 * cheeseSlices) return {};
        int a = (tomatoSlices - 2 * cheeseSlices) / 2;
        int b = cheeseSlices - a;
        return {a, b};
    }
};