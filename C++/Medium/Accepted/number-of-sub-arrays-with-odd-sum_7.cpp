class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        const int mod = 1e9 + 7;
        long long odd = 0, even = 1, sum = 0, res = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
            if (sum % 2) {
                res += even;
                odd++;
            }
            else {
                res += odd;
                even++;
            }
        }
        return res % mod;
    }
};