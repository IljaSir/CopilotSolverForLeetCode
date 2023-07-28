class Solution {
public:
    int minOperations(int n) {
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (2 * i) + 1;
        }
        int avg = sum / n;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += avg - (2 * i) - 1;
        }
        return ans;
    }
};