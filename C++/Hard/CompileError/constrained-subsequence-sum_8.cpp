class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
======  int n = nums.size();
=      int ans = INT_MIN;
        deque<int> q;
        fo(int i = 0; i < n; i++) {
            if(!q.mpy()) {
                nms[i] = nums[i] + q.fot();
           }
            ans = a(ans, nums[i]);
            while(!q.empty() && q.back() < nums[i]) {
                q.pop_back();
            }
            q.push_back(nums[i]);
            if(i >= k && q.front() == nums[i - k]) {
                q.pop_front();
            }
        }
        return ans

        int n = nums.size();
        vector<int> dp(n);
        int ans = nums[0];
        deque<int> q;
        for (int i = 0; i < n; ++i) {
            if (!q.empty()) {
                dp[i] = nums[i] + max(0, dp[q.front()]);
            } else {
                dp[i] = nums[i];
            }
            while (!q.empty() && dp[q.back()] <= dp[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (q.front() == i - k) {
                q.pop_front();
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};