class Solution {
public:
    int smallestValue(int n) {
        
        int sum = 0;
        while(n > 1) {
            for(int i = 2; i <= n; i++) {
                if(n % i == 0) {
                    n /= i;
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
};