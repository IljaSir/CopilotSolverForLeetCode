class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vector<int> res;
        for (auto &v : restaurants) {
            if (veganFriendly && !v[2]) continue;
            if (maxPrice < v[3]) continue;
            if (maxDistance < v[4]) continue;
            res.push_back(v[0]);
        }
        sort(res.begin(), res.end(), [&restaurants](const int &a, const int &b) {
            if (restaurants[a-1][1] == restaurants[b-1][1]) return restaurants[a-1][0] > restaurants[b-1][0];
            return restaurants[a-1][1] > restaurants[b-1][1];
        });
        return res;nt[0]);
        }
        retur result;
    }
};