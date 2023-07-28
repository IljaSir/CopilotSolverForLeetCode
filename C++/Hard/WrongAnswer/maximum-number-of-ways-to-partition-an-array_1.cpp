class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> preSum(n + 1);
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int maxWays = 0;
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; i++) {
            int leftSum = preSum[i];
            int rightSum = preSum[n] - preSum[i];
            if (leftSum == rightSum) {
                maxWays++;
            }
            cnt[leftSum - rightSum]++;
        }
        int ans = maxWays;
        for (int i = 0; i < n; i++) {
            int leftSum = preSum[i];
            int rightSum = preSum[n] - preSum[i];
            cnt[leftSum - rightSum]--;
            if (cnt[leftSum - rightSum] == 0) {
                cnt.erase(leftSum - rightSum);
            }
            leftSum += k;
            rightSum -= k;
            if (leftSum == rightSum) {
                maxWays++;
            }
            cnt[leftSum - rightSum]++;
            ans = max(ans, maxWays);
        }
        return ans;
    }
};