class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int size = arr.size();
        int sum = 0;
        int odd = 0;
        int even = 1;
        int res = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                res += even;
                odd++;
            } else {
                res += odd;
                even++;
            }
            res %= 1000000007;
        }
        return res;
    }
};