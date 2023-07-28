class Solution {
public:
    int smallestValue(int n) {
        
        int ans = 0;
        while(n > 1){
            int m = n;
            for(int i = 2; i <= n; i++){
                if(n % i == 0){
                    ans += i;
                    while(n % i == 0){
                        n /= i;
                    }
                }
            }
            if(m == n) break;
        }
        return ans;
    }
};