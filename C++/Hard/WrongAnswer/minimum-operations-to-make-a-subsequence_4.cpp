class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < target.size(); i++) {
            m[target[i]] = i;
        }
        vector<int> t;
        for (int i = 0; i < arr.size(); i++) {
            if (m.count(arr[i])) {
                t.push_back(m[arr[i]]);
            }
        }
        vector<int> dp(t.size(), 1);
        int res = 1;
        for (int i = 1; i < t.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] < t[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return target.size() - res;
    }
};