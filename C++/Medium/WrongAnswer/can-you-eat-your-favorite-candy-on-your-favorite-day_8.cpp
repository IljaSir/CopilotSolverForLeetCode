class Solution {
public:
    vector<bool> canEat(vector<int>& candiesCount, vector<vector<int>>& queries) {
        
        vector<long long> sum;
        long long s = 0;
        for (int i = 0; i < candiesCount.size(); i++) {
            s += candiesCount[i];
            sum.push_back(s);
        }
        vector<bool> ans;
        for (int i = 0; i < queries.size(); i++) {
            long long min = queries[i][1] + 1;
            long long max = (long long)(queries[i][1] + 1) * queries[i][2];
            if (queries[i][0] == 0) {
                if (max >= sum[0]) {
                    ans.push_back(true);
                } else {
                    ans.push_back(false);
                }
            } else {
                if (min <= sum[queries[i][0]] && max >= sum[queries[i][0] - 1] + 1) {
                    ans.push_back(true);
                } else {
                    ans.push_back(false);
                }
            }
        }
        return ans;
    }
};