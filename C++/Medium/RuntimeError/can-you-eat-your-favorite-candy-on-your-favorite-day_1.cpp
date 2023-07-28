class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        int n = candiesCount.size();
        vector<long long> prefix(n);
        prefix[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i-1] + candiesCount[i];
        }
        vector<bool> ans;
        for (auto& query : queries) {
            int type = query[0];
            int day = query[1];
            int cap = query[2];
            long long x1 = day + 1;
            long long y1 = (day + 1) * cap;
            long long x2 = type == 0 ? 1 : prefix[type - 1] + 1;
            long long y2 = prefix[type];
            ans.push_back(!(x1 > y2 || y1 < x2));
        }
        return ans;
    }
};