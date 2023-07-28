class Solution {
public:
    int minOperations(int n) {
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 2 * i + 1;
        }
        int target = sum / n;
        int ret = 0;
        for (int i = 0; i < n / 2; i++) {
            ret += target - 2 * i - 1;
        }
        return ret;
    }
};