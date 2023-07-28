class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        unordered_map<int, int> cnt;
        for (int i = 2; i <= n; i++) {
            int left = preSum[i - 1];
            int right = preSum[n] - preSum[i - 1];
            if (left == right) {
                res++;
            }
            cnt[left - right]++;
        }
        int ans = res;
        for (int i = 1; i <= n; i++) {
            int left = preSum[i - 1] + k;
            int right = preSum[n] - preSum[i - 1] - k;
            if (left == right) {
                ans = max(ans, res + 1);
            }
            if (cnt.count(left - right)) {
                ans = max(ans, res + cnt[left - right]);
            }
        }
        return ans;
    }
};