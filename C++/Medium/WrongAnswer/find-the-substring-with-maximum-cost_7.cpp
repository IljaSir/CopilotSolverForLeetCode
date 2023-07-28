class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int n = s.size();
        int m = chars.size();
        vector<int> cost(n, 0);
        vector<int> value(26, 0);
        for (int i = 0; i < m; i++) {
            value[chars[i] - 'a'] = vals[i];
        }
        
        for (int i = 0; i < n; i++) {
            int v = value[s[i] - 'a'];
            cost[i] = v;
            if (i > 0 && cost[i - 1] > 0) {
                cost[i] += cost[i - 1];
            }
        }
        int maxCost = 0;
        for (int i = 0; i < n; i++) {
            maxCost = max(maxCost, cost[i]);
        }
        return maxCost;
    }
};