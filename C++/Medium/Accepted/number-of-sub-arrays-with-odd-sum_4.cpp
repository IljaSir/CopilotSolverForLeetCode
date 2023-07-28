class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> odd(n, 0);
        vector<int> even(n, 0);
        if (arr[0] % 2) {
            odd[0] = 1;
        } else {
            even[0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            if (arr[i] % 2) {
                odd[i] = even[i - 1] + 1;
                even[i] = odd[i - 1];
            } else {
                even[i] = even[i - 1] + 1;
                odd[i] = odd[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += odd[i];
            ans %= 1000000007;
        }
        return ans;
    }
};