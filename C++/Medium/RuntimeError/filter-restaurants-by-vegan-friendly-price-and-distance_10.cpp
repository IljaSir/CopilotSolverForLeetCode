class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> ans;
        for (auto& v : restaurants) {
            if ((veganFriendly == 0 || v[2] == veganFriendly) && v[3] <= maxPrice && v[4] <= maxDistance) {
                ans.push_back(v[0]);
            }
        }
        sort(ans.begin(), ans.end(), [&](int i, int j) {
            return restaurants[i-1][1] == restaurants[j-1][1] ? i > j : restaurants[i-1][1] > restaurants[j-1][1];
        });
        return ans;
    }
};