class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        vector<long long> sum(candiesCount.size());
        sum[0] = candiesCount[0];
        for(int i = 1; i < candiesCount.size(); i++){
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        vector<bool> ans;
        for(auto q: queries){
            int favoriteType = q[0];
            int favoriteDay = q[1];
            int dailyCap = q[2];
            long long x1 = favoriteDay + 1;
            long long y1 = (long long)(favoriteDay + 1) * dailyCap;
            long long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long long y2 = sum[favoriteType];
            ans.push_back(!(x1 > y2 || y1 < x2));
        }
        return ans;
    }
};