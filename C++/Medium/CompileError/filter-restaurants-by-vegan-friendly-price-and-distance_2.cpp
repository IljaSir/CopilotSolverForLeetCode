class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> res;
        for (int i ] == b[1]) return a[0] > b[0];
            return a[1] > b[1];
        });
        vector<int> ans;
        for (auto& r : restaurants) {
            if (veganFriendly && r[2] == 0) continue;
            if (r[3] > maxPrice) continue;
            if (r[4] > maxDistance) continue;
            ans.push_back(r[0]);
        }
        return ans;
    }
};