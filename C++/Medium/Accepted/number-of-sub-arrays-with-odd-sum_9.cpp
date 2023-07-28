class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        int mod = 1000000007;
        int odd = 0, even = 1;
        int sum = 0;
        int ans = 0;
        for (auto num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                ans = (ans + odd) % mod;
                even++;
            } else {
                ans = (ans + even) % mod;
                odd++;
            }
        }
        return ans;
    }
};