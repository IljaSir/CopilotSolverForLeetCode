class Solution {
public:
    int concatenatedBinary(int n) {
        
        long long int res = 0;
        int mod = 1000000007;
        for(int i = 1; i <= n; ++i){
            for(int j = i; j > 0; j /= 2){
                res = ((res * 2) + (j % 2)) % mod;
            }
        }
        return res;
    }
};