class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<long long> preSum(n + 1);
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        long long res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int j = i + k - 1;
            if (j >= n) break;
            long long sum = preSum[j + 1] - preSum[i];
            long long minVal = sum / k;
            long long maxVal = minVal + 1;
            long long minCnt = k - sum % k;
            long long maxCnt = sum % k;
            long long val = minCnt * pow(minVal, 2) + maxCnt * pow(maxVal, 2);
            res = min(res, val);
        }
        return res;
    }
};