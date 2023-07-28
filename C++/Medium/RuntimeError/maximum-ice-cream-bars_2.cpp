class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int count[100001] = {0};
        int result = 0;
        for (int i = 0; i < costs.size(); i++) {
            count[costs[i]]++;
        }
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                if (count[i] > 0) {
                    if (coins >= i * count[i]) {
                        coins -= i * count[i];
                        result += count[i];
                    } else {
                        result += coins / i;
                        coins = 0;
                    }
                }
            } else {
                break;
            }
        }
        return result;
    }
};