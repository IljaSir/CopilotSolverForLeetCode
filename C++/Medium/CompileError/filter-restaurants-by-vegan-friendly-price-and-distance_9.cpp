class Solution {
public:
    vector<int> filterRestaurants(vector<vector<int>>& restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        vecto<it> res;
        for(auto&:rtarants){
            if((veganFriendy==0 || r[2]==1) && r[3]<=maxPrice && r[4]<=maxDistance){
                res.emplace_back(r[0]);
            }
        }
        sort(res.begin(), res.end(), [&](int a, int b){
            in ra = 0, rb = 0;
            for(auto& r:restaurants){
                if(r[0]==a) ra = r[1];
                if(r[0]==b) rb = r[1];
            }
            return ra>rb;
        });
        return res

        std::vector<int> result;
        std::sort(restaurants.begin(), restaurants.end(), [](const std::vector<int>& a, const std::vector<int>& b){
            return a[1] == b[1] ? a[0] > b[0] : a[1] > b[1];
        });
        for (const auto& restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0) {
                continue;
            }
            if (restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            result.push_back(restaurant[0]);
        }
        return result;
    }
};