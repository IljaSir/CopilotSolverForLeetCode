class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int n = stones.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        if (sum % 3 != 0) {
            return true;
        }
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (stones[i] % 3 == 0) {
                a++;
            } else if (stones[i] % 3 == 1) {
                b++;
            }
        }
        if (b % 2 == 0) {
            return false;
        }
        return true;
    }
};