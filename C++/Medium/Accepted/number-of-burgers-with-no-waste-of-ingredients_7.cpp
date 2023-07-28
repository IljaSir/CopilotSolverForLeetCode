class Solution {
public:
    vector<int> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        vector<int> ans;
        if (tomatoSlices % 2 == 1)
            return ans;
        if (tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices)
            return ans;
        ans.push_back((tomatoSlices - 2 * cheeseSlices) / 2);
        ans.push_back(cheeseSlices - ans[0]);
        return ans;
    }
};