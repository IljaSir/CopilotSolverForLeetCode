class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int max = 0;
        int c[100001] = {0};
        for (auto cost : costs) {
            c[cost]++;
        }
        for (int i = 1; i < 100001; i++) {
            if (c[i]) {
                if (coins >= i) {
                    int n = coins / i;
                    if (n >= c[i]) {
                        max += c[i];
                        coins -= c[i] * i;
                    } else {
                        max += n;
                        coins -= n * i;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }
};