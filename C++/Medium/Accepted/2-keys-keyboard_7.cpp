class Solution {
public:
    int minSteps(int n) {
        
        int i = 2;
        int res = 0;
        while(i <= n){
            while(n%i == 0){
                res += i;
                n /= i;
            }
            i++;
        }
        return res;
    }
};