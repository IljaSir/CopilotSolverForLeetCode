class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        vector<long long> sum(candiesCount.size());
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.size(); i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }
        vector<bool> ans;
        for (auto& query: queries) {
            int type = query[0];
            int day = query[1];
            int cap = query[2];
            long long min = type == 0 ? 0 : sum[type - 1];
            long long max = sum[type];
            ans.push_back(min <= day && day < max && day * cap + cap > min);
        }
        return ans;
    }
};