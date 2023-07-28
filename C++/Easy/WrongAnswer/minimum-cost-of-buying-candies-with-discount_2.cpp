class Solution {
public:
    int minimumCost(vector<int>& cost) {
        
        int n = cost.size();
        sort(cost.begin(), cost.end());
        int ans = 0;
        for (int i = 0; i < n; i += 3) {
            ans += cost[i];
        }
        return ans;
    }
};