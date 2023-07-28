class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        long long int mod = 1000000007;
        long long int len = arr.size();
        long long int sum = 0;
        long long int max_sum = 0;
        long long int min_sum = 0;
        long long int sum1 = 0;
        long long int sum2 = 0;
        long long int sum3 = 0;
        for (int i = 0; i < len; i++) {
            sum1 += arr[i];
            if (sum1 > sum2)
                sum2 = sum1;
            if (sum1 < 0)
                sum1 = 0;
        }
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (sum > max_sum)
                max_sum = sum;
            if (sum < min_sum)
                min_sum = sum;
        }
        if (k == 1)
            return sum2 % mod;
        sum3 = sum;
        for (int i = 0; i < len; i++) {
            sum3 += arr[i];
            if (sum3 > sum1)
                sum1 = sum3;
            if (sum3 < 0)
                sum3 = 0;
        }
        if (sum > 0)
            return max(sum1 % mod, ((k - 2) * sum + max_sum - min_sum) % mod);
        else
            return max(sum1 % mod, max_sum % mod);
    }
};