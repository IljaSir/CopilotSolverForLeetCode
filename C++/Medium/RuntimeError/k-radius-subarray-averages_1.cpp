class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n, 0);
        vector<int> prefixSum(n, 0);
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = i - k;
            int right = i + k;
            int total = 0;
            if (left < 0) {
                total = prefixSum[right];
            } else if (right >= n) {
                total = prefixSum[n - 1] - prefixSum[left - 1];
            } else {
                total = prefixSum[right] - prefixSum[left - 1];
            }
            if (right - left + 1 >= 2 * k + 1) {
                avgs[i] = total / (2 * k + 1);
            } else {
                avgs[i] = -1;
            }
        }
        return avgs;
    }
    vector<int> averageOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n, 0);
        vector<int> prefixSum(n, 0);
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = i - k;
            int right = i + k;
            int total = 0;
            if (left < 0) {
                total = prefixSum[right];
            } else if (right >= n) {
                total = prefixSum[n - 1] - prefixSum[left - 1];
            } else {
                total = prefixSum[right] - prefixSum[left - 1];
            }
            if (right - left + 1 >= 2 * k + 1) {
                avgs[i] = total / (2 * k + 1);
            } else {
                avgs[i] = -1;
            }
        }
        return avgs;
    }
};