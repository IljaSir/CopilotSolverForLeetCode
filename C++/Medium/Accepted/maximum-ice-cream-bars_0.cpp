class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int count[100001] = {0};
        for (int i = 0; i < costs.size(); i++) {
            count[costs[i]]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int c = min(count[i], coins / i);
                ans += c;
                coins -= c * i;
            } else {
                break;
            }
        }
        return ans;
    }
};