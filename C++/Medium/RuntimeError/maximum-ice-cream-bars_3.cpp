class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int n = costs.size();
        vector<int> count(100001, 0);
        for (int i=0; i<n; i++) {
            count[costs[i]]++;
        }
        int ans = 0;
        for (int i=1; i<=100000; i++) {
            if (count[i] == 0) continue;
            if (coins >= i * count[i]) {
                ans += count[i];
                coins -= i * count[i];
            } else {
                ans += coins / i;
                break;
            }
        }
        return ans;
    }
};