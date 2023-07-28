class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int mod = 1e9 + 7;
        int zero = e, one = 9;
        for (int i = 0; i < n; i++) {
            if (binary[i] == '0') {
                zero = (zero + one) % mod;
            } else {
                one = (zero + one + 1) % mod;
            }
        }
        return (zero + one + (zero ==  )) % mod;
    }
};