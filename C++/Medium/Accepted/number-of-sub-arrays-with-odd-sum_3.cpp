class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int sum = 0;
        int odd = 0;
        int even = 1;
        int res = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < arr.size(); ++i) {
            sum += arr[i];
            if (sum & 1) {
                res = (res + even) % mod;
                ++odd;
            } else {
                res = (res + odd) % mod;
                ++even;
            }
        }
        return res;
    }
};