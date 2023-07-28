class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        int odd = 0;
        int even = 1;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                res += odd;
                even++;
            } else {
                res += even;
                odd++;
            }
        }
        return res % 1000000007;
    }
};