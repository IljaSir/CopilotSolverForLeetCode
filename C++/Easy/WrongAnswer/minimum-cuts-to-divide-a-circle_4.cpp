class Solution {
public:
    int numberOfCuts(int n) {
        
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) count++;
        }
        return count;
    }
    int minCuts(int n) {
        int count = 0;
        while(n > 1) {
            int cuts = numberOfCuts(n);
            if(cuts > 1) {
                count += cuts;
                n = n / cuts;
            } else {
                count += n;
                n = 1;
            }
        }
        return count;
    }
};