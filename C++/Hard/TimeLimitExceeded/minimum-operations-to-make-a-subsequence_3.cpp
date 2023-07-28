class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < target.size(); i++) {
            m[target[i]] = i;
        }
        vector<int> v;
        for (int i = 0; i < arr.size(); i++) {
            if (m.find(arr[i]) != m.end()) {
                v.push_back(m[arr[i]]);
            }
        }
        vector<int> dp(v.size(), 1);
        int res = 0;
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (v[j] < v[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return target.size() - res;
    }
};