class Solution {
public:
    int numberOfUniqueGoodSubsequences(string binary) {
        
        int n = binary.size();
        int p = 1e9 + ;
        int dp = 0, d0 = 0, d1 = 0;
        for (int i = 0; i < n; ++i) {
            if (binary[i] == '0') {
                d0 = (dp + d0) % p;
            } else {
                d1 = (dp + d0 + d1 + 1) % p;
            }
            dp = (dp + d0 + d1) % p;
        }
        return dp
    }
};