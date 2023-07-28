class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> res;
        for (const auto& r : restaurants) {
            if (r[2] < veganFriendly || r[3] > maxPrice || r[4] > maxDistance) {
                continue;
            }
            res.push_back(r[0]);
        }
        sort(res.begin(), res.end(), [&restaurants](int i1, int i2) {
            if (restaurants[i1][1] == restaurants[i2][1]) {
                return restaurants[i1][0] > restaurants[i2][0];
            }
            return restaurants[i1][1] > restaurants[i2][1];
        });
        return res;
    }
};