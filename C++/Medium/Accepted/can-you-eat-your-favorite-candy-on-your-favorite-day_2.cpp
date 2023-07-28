class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<long long> sum(n + 1);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + candiesCount[i];
        }
        vector<bool> ans;
        for (auto& q: queries) {
            int favoriteType = q[0], favoriteDay = q[1], dailyCap = q[2];
            long long x1 = favoriteDay + 1;
            long long y1 = (long long)(favoriteDay + 1) * dailyCap;
            long long x2 = sum[favoriteType] + 1;
            long long y2 = sum[favoriteType + 1];
            ans.push_back(!(x1 > y2 || y1 < x2));
        }
        return ans;
    }
};