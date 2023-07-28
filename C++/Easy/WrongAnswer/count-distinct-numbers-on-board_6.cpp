class Solution {
public:
    int distinctIntegers(int n) {
        
        if(n == 1) return 1;
        int res = 0;
        for(int i = 1; i <= n; i++){
            int j = 2;
            int cnt = 0;
            while(i * j <= n){
                cnt++;
                j++;
            }
            res += cnt + 1;
        }
        return res;
    }
};