class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        deque<int> dq;
        int res = nums[0];
        for (int i = 0; i < n; ++i) {
            if (!dq.empty()) {
                nums[i] = max(nums[i], nums[dq.front()] + nums[i]);
            }
            res = max(res, nums[i]);
            while (!dq.empty() && nums[dq.back()] <= nums[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            if (dq.front() == i - k) {
                dq.pop_front();
            }
        }
        return res;
    }
};