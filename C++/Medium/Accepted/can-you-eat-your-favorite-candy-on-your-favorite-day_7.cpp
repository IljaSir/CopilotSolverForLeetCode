class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        vector<bool> result;
        vector<long> sum(candiesCount.size());
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.size(); ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        for (auto& query : queries) {
            int type = query[0];
            int day = query[1];
            int cap = query[2];
            long x1 = day + 1;
            long y1 = (long)(day + 1) * cap;
            long x2 = type == 0 ? 1 : sum[type - 1] + 1;
            long y2 = sum[type];
            result.push_back(!(x1 > y2 || y1 < x2));
        }
        return result;
    }
};