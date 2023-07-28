class Solution {
public:
    int minimumSum(int num) {
        
        int a[5], i = 0;
        while(num) {
            a[i++] = num % 10;
            num /= 10;
        }
        int ans = 0;
        for(int j = 0; j < (1 << 4); j++) {
            int x = 0, y = 0;
            for(int k = 0; k < 4; k++) {
                if(j & (1 << k)) {
                    x = x * 10 + a[k];
                } else {
                    y = y * 10 + a[k];
                }
            }
            ans = ans ? min(ans, x + y) : x + y;
        }
        return ans;
    }
};