class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int maxCost = 0;
        int n = s.size();
        int m = chars.size();
        vector<int> charValue(26, 0);
        for (int i = 0; i < m; i++) {
            charValue[chars[i] - 'a'] = vals[i];
        }
        vector<int> cost(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            cost[i] = cost[i - 1] + charValue[s[i - 1] - 'a'];
            int minCost = 0;
            for (int j = i; j > 0; j--) {
                minCost = min(minCost, cost[j - 1]);
                maxCost = max(maxCost, cost[i] - minCost);
            }
        }
        return maxCost;
    }
};