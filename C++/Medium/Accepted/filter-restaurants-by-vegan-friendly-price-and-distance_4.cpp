class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> result;
        for (int i = 0; i < restaurants.size(); ++i) {
            if (veganFriendly && !restaurants[i][2]) {
                continue;
            }
            if (maxPrice < restaurants[i][3]) {
                continue;
            }
            if (maxDistance < restaurants[i][4]) {
                continue;
            }
            result.push_back(i);
        }
        sort(result.begin(), result.end(), [&restaurants](int a, int b) {
            if (restaurants[a][1] == restaurants[b][1]) {
                return restaurants[a][0] > restaurants[b][0];
            }
            return restaurants[a][1] > restaurants[b][1];
        });
        vector<int> ids;
        for (auto i : result) {
            ids.push_back(restaurants[i][0]);
        }
        return ids;
    }
};