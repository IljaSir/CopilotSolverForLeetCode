class Solution {
public:
    int minOperations(int n) {
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (2 * i) + 1;
        }
        int target = sum / n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += abs(target - ((2 * i) + 1));
        }
        return res / 2;
    }
};