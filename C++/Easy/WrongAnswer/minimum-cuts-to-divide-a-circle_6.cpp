class Solution {
public:
    int numberOfCuts(int n) {
        
        int count = 0;
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n /= i;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
    int minCuts(int n) {
        if (n == 1) return 0;
        int count = numberOfCuts(n);
        int ans = 0;
        while (count > 1) {
            count = numberOfCuts(count);
            ans++;
        }
        return ans;
    }
};