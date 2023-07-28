class Solution {
public:
    int pivotInteger(int n) {
        
        int sum = 0;
        for(int i=1;i<=n;i++) {
            sum += i;
            if(sum == n*(n+1)/2 - sum + i) {
                return i;
            }
        }
        return -1;
    }
};