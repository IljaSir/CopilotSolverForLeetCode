class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> res;
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                res.push_back(i);
            }
        }
        sort(res.begin(), res.end(), [&](int a, int b) {
            if (restaurants[a][1] == restaurants[b][1]) {
                return restaurants[a][0] > restaurants[b][0];
            }
            return restaurants[a][1] > restaurants[b][1];
        });
        vector<int> ans;
        for (int i = 0; i < res.size(); i++) {
            ans.push_back(restaurants[res[i]][0]);
        }
        return ans;
    }
};