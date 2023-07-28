class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int n = arr.size();
        int mod = 1e9 + 7;
        long long int sum = 0;
        long long int max_so_far = 0;
        long long int max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max_ending_here += arr[i];
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
        }
        if (k == 1) {
            return max_so_far % mod;
        }
        if (sum <= 0) {
            return max_so_far % mod;
        }
        long long int max_ending_here_2 = 0;
        long long int max_so_far_2 = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here_2 += arr[i];
            if (max_ending_here_2 < 0) {
                max_ending_here_2 = 0;
            }
            if (max_so_far_2 < max_ending_here_2) {
                max_so_far_2 = max_ending_here_2;
            }
        }
        long long int max_ending_here_3 = 0;
        long long int max_so_far_3 = 0;
        for (int i = n - 1; i >= 0; i--) {
            max_ending_here_3 += arr[i];
            if (max_ending_here_3 < 0) {
                max_ending_here_3 = 0;
            }
            if (max_so_far_3 < max_ending_here_3) {
                max_so_far_3 = max_ending_here_3;
            }
        }
        long long int ans = max_so_far;
        ans = max(ans, sum * (k - 2) + max_so_far_2 + max_so_far_3);
        return ans % mod;
    }
};