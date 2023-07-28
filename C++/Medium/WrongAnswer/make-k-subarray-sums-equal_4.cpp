class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        long long sum = 0;
        for (int i = 0; i < arr.size(); ++i)
            sum += arr[i];
        if (sum % k != 0)
            return -1;
        long long target = sum / k;
        long long ans = 0;
        long long cur = 0;
        for (int i = 0; i < arr.size(); ++i) {
            cur += arr[i];
            if (i >= k - 1) {
                long long diff = cur - target;
                if (diff > 0)
                    ans += diff;
                else
                    ans -= diff;
                cur -= arr[i - k + 1];
            }
        }
        return ans;
    }
};