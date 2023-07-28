class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        
        vector<int> res;
        if (nums.empty() || k <= 0) return res;
        deque<int> dq;
        for (int i = 0; i < nums.size(); i++) {
            // remove the elements out of range
            while (!dq.empty() && dq.front() < i - k + 1) {
                dq.pop_front();
            }
            // remove the elements smaller than nums[i]
            while (!dq.empty() && nums[dq.back()] < nums[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            if (i >= k - 1) {
                res.push_back(nums[dq.front()]);
            }
        }
        return res;
    }
};