class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        deque<int> dq;
        int ans = INT_MIN;
        for (int i = 0; i < n; ++i) {
            if (dq.size() && i - dq.front() > k) {
                dq.pop_front();
            }
            if (dq.size()) {
                nums[i] += nums[dq.front()];
            }
            while (dq.size() && nums[dq.back()] <= nums[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            ans = max(ans, nums[i]);
        }
        return ans;
    }
};