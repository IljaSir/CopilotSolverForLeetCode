class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> res;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants[i][2] < veganFriendly) continue;
            if (restaurants[i][3] > maxPrice) continue;
            if (restaurants[i][4] > maxDistance) continue;
            res.push_back(restaurants[i][0]);
        }
        sort(res.begin(), res.end(), [restaurants](int a, int b) {
            int i = 0, j = 0;
            while (restaurants[i][0] != a) i++;
            while (restaurants[j][0] != b) j++;
            if (restaurants[i][1] == restaurants[j][1]) return restaurants[i][0] > restaurants[j][0];
            return restaurants[i][1] > restaurants[j][1];
        });
        return res;
    }
};